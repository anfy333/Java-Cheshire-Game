package game;

import city.cs.engine.BodyImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * A panel that represents the main menu of the game.
 */
public class Menu extends JPanel {
    JFrame frame;
    JFrame menuFrame;
    JButton start;
    GameView view;
    Image bg = new ImageIcon("data/menu.png").getImage();
    public static final Font STATUS_FONT = new Font("Helvetica", Font.BOLD, 50);
    /**
     * Overrides the paintComponent method to draw the background image and title text.
     *
     * @param g The Graphics object used to paint the component.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(bg, 0, 0, 800, 800, this);
        g.setColor(Color.BLACK);
        g.setFont(STATUS_FONT);
        g.drawString("Cheshire's Adventures!", 120, 95);
    }
    /**
     * Constructs a menu panel with the specified frame, menu frame, and game view.
     *
     * @param frame     The main frame of the game.
     * @param menuFrame The menu frame.
     * @param view      The game view.
     */
    public Menu(JFrame frame,JFrame menuFrame, GameView view){
        //this.game = game;
        this.frame = frame;
        this.view = view;
        this.menuFrame = menuFrame;
        start = new JButton("Play");
        this.setLayout(null);
        start.setBounds(300,500,200,50);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(false);
                frame.setVisible(true);
                frame.add(view);
                frame.revalidate();

            }
        });
        add(start);
    }
}
