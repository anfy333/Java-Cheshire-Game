package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Represents the panel displayed when Cheshire falls asleep.
 */
public class Sleep extends JPanel {
    JFrame sleepFrame;
    JFrame frame;
    JButton restart;
    Game game;
    GameView view;
    Image bg = new ImageIcon("data/sleep.png").getImage();
    public static final Font STATUS_FONT = new Font("Helvetica", Font.BOLD, 30);
    /**
     * Overrides the paintComponent method to draw the background image and status message.
     *
     * @param g The Graphics object.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(bg, 0, 0, 800, 800, this);
        g.setColor(Color.BLACK);
        g.setFont(STATUS_FONT);
        g.drawString("Oh no! Seems like Cheshire fell asleep...", 90, 500);
    }
    /**
     * Constructs the Sleep panel with the specified game, frames, and view.
     *
     * @param game       The game instance.
     * @param frame      The main game frame.
     * @param view       The game view.
     * @param sleepFrame The frame for the Sleep panel.
     */
    public Sleep(Game game, JFrame frame, GameView view, JFrame sleepFrame) {
        this.game = game;
        this.frame = frame;
        this.view = view;
        this.sleepFrame = sleepFrame;
        this.setLayout(null);
        this.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int length = (int) ((dimension.getWidth()- sleepFrame.getWidth())/2);
        int height = (int) ((dimension.getHeight()- sleepFrame.getHeight())/2);
        sleepFrame.setLocation(length,height);
    }

}
