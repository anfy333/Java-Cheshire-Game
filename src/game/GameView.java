package game;
import city.cs.engine.*;
import javax.swing.*;
import java.awt.*;
import city.cs.engine.UserView;
/**
 * Represents the view of the game.
 */
public class GameView extends UserView {
    private Image background;
    private Image healthIcon;
    private Image mushroomIcon;
    public static final Font STATUS_FONT = new Font("Monospaced", Font.BOLD, 20);
    private GameLevel world;
    /**
     * Constructs a new GameView.
     *
     * @param world The GameLevel associated with this view.
     * @param width The width of the view.
     * @param height The height of the view.
     */
    public GameView(GameLevel world, int width, int height){
        super (world, width, height);
        this.world = world;
        background = new ImageIcon("data/forest pixel.png").getImage();
        healthIcon = new ImageIcon("data/energy100.png").getImage();
        mushroomIcon = new ImageIcon("data/mushroom.png").getImage();
    }
    /**
     * Paints the background of the view.
     *
     * @param g The Graphics2D object used for painting.
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0,800,800, this);
    }
    /**
     * Paints the foreground of the view.
     *
     * @param g The Graphics2D object used for painting.
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        int mushrooms = world.getCheshire().getMushrooms();
        int h = world.getCheshire().getHealth();
        healthBar(h);
        g.setColor(Color.BLACK);
        g.setFont(STATUS_FONT);
        g.drawImage(mushroomIcon,565,60,50,50,this);
        g.drawString(": " + mushrooms, 620, 95);
        g.drawImage(healthIcon,570,5,this);
    }

    /**
     * Updates the health icon based on the health value.
     *
     * @param h The health value.
     */
    public void healthBar(int h){
        if (h == 100){
            healthIcon = new ImageIcon("data/energy100.png").getImage();
        }
        if (h == 80){
            healthIcon = new ImageIcon("data/energy80.png").getImage();
        }
        if (h == 60){
            healthIcon = new ImageIcon("data/energy60.png").getImage();
        }
        if (h == 40){
            healthIcon = new ImageIcon("data/energy40.png").getImage();
        }
        if (h == 20){
            healthIcon = new ImageIcon("data/energy20.png").getImage();
        }
        if (h == 0){
            healthIcon = new ImageIcon("data/energy0.png").getImage();
        }
    }
}
