package game;

import city.cs.engine.*;

import javax.swing.JFrame;

import java.awt.*;

/**
 * Your main game entry point
 */
public class Game {
    private CatController controller;
    private GameLevel level;
    private GameView view;
    JFrame sleepFrame;
    JFrame frame;
    JFrame completeFrame;
    /**
     * Initialise a new Game.
     */
    public Game() {

        level = new Level1(this);
        //JFrame debugView = new DebugViewer(level, 800, 800);

        //3. make a view to look into the game world
        view = new GameView(level, 800, 800);
        view.addMouseListener(new GiveFocus());
        level.addStepListener(new Camera(view, level.getCheshire()));

        controller = new CatController(level.getCheshire(),level);
        view.addKeyListener(controller);

        //optional: draw a 1-metre grid over the view
        //view.setGridResolution(1);

        frame = new JFrame("Cheshire's Adventures: game");
        JFrame menuFrame = new JFrame("Cheshire's Adventures: menu");
        sleepFrame = new JFrame("Cheshire's Adventures: oh no! Cheshire's energy run out...");
        completeFrame = new JFrame("Cheshire's Adventures: game complete!");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setPreferredSize(new Dimension(800, 800));
        sleepFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sleepFrame.setPreferredSize(new Dimension(800, 800));
        completeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        completeFrame.setPreferredSize(new Dimension(800, 800));
        frame.setPreferredSize(new Dimension(800, 800));

        Menu menu = new Menu(frame,menuFrame,view);

        menuFrame.add(menu);

        // Set the JFrame visible
        menuFrame.setVisible(true);
        menuFrame.pack();
        frame.add(view);
        frame.pack();

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        menuFrame.setResizable(false);

        //StackOverflow code
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int length = (int) ((dimension.getWidth()- menuFrame.getWidth())/2);
        int height = (int) ((dimension.getHeight()- menuFrame.getHeight())/2);
        menuFrame.setLocation(length,height);

        frame.setLocation(length,height);

        level.start();
        level.addStepListener(new StepListener() {
            @Override
            public void preStep(StepEvent e) {
                if (level.isComplete()) {
                    goToNextLevel();
                }
                if(level.isSleepy()){
                    goToNextLevel();
                }
            }

            @Override
            public void postStep(StepEvent e) {
                // Empty method body
            }
        });
    }
    /**
     * Gets the current game level.
     *
     * @return The current game level.
     */
    public GameLevel getLevel(){
        return level;
    }
    /**
     * Advances to the next game level.
     * If the current level is complete, it stops the level and starts the next one.
     * If the energy level is 0 on the current level (sleepy), it displays a sleep screen.
     */
    public void goToNextLevel() {
        if (level.isComplete()) {
            level.stop();
            if (level instanceof Level1) {
                level = new Level2(this);
            } else if (level instanceof Level2) {
                level = new Level3(this);
            } else if (level instanceof Level3) {
                Complete complete = new Complete(this,frame,view,completeFrame);
                frame.setVisible(false);
                completeFrame.setVisible(true);
                completeFrame.add(complete);
                completeFrame.revalidate();
                completeFrame.pack();
            }

            // Set up new level
            view.setWorld(level);
            controller = new CatController(level.getCheshire(),level);
            level.getCheshire().setHealth(100);
            level.getCheshire().setMushroomCount(0);
            //level.getCheshire().setBullets(0);
            view.addKeyListener(controller);
            view.addMouseListener(new GiveFocus());
            level.addStepListener(new Camera(view, level.getCheshire()));
            level.start();
            level.addStepListener(new StepListener() {
                @Override
                public void preStep(StepEvent e) {
                    //System.out.println(level.getCheshire().getMushrooms());
                    if (level.isComplete()) {
                        goToNextLevel();
                    }
                    if(level.isSleepy()){
                        goToNextLevel();
                    }
                }
                @Override
                public void postStep(StepEvent e) {
                    // Empty method body
                }
            });
            }
        else if (level.isSleepy()){
                Sleep over = new Sleep(this,frame,view,sleepFrame);
                frame.setVisible(false);
                sleepFrame.setVisible(true);
                sleepFrame.add(over);
                sleepFrame.revalidate();
                sleepFrame.pack();

            }
        }

    /**
     * Runs the game.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main (String[]args){

        new Game();
    }
}
