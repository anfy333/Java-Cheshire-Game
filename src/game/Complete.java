package game;

import javax.swing.*;
import java.awt.*;
/**
 * Represents the panel displayed when the game is completed.
 */
public class Complete extends JPanel {
    JFrame completeFrame;
    JFrame frame;
    Game game;
    GameView view;
    Image bg = new ImageIcon("data/menu.png").getImage();
    public static final Font STATUS_FONT = new Font("Helvetica", Font.BOLD, 30);
    /**
     * Overrides the paintComponent method to draw the completion message and background image.
     *
     * @param g The Graphics object used for drawing.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(bg, 0, 0, 800, 800, this);
        g.setColor(Color.BLACK);
        g.setFont(STATUS_FONT);
        g.drawString("Yay! Game is complete!", 210, 500);
    }

    public Complete(Game game, JFrame frame, GameView view, JFrame completeFrame) {
        this.game = game;
        this.frame = frame;
        this.view = view;
        this.completeFrame = completeFrame;
        this.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int length = (int) ((dimension.getWidth()- 800)/2);
        int height = (int) ((dimension.getHeight()- 800)/2);
        completeFrame.setLocation(length,height);
    }
}
