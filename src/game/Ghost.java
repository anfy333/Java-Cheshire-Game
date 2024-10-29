package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Represents a ghost entity in the game.
 */
public class Ghost extends Walker implements StepListener{
    private static final BodyImage ghostImage = new BodyImage("data/ghost.png", 4f);
    private static final Shape ghostShape = new BoxShape(1,2);
    private int SPEED = 2;
    private float left, right;
    private static int RANGE = 2;
    public int health = 100;
    /**
     * Sets the range of the ghost's movement.
     *
     * @param r The new range.
     */
    public static void setRANGE(int r){RANGE = r;}
    /**
     * Gets the range of the ghost's movement.
     *
     * @return The range.
     */
    public static int getRANGE(){return RANGE;}
    /**
     * Sets the health of the ghost.
     *
     * @param h The new health value.
     */
    public void setHealth(int h){health = h;}
    /**
     * Gets the health of the ghost.
     *
     * @return The health value.
     */
    public int getHealth(){return health;}
    /**
     * Constructs a ghost object with the specified speed.
     *
     * @param world The world in which the ghost exists.
     * @param SPEED The speed of the ghost.
     */
    public Ghost(World world, int SPEED) {
        super(world, ghostShape);
        addImage(ghostImage);
        world.addStepListener(this);
        this.SPEED = SPEED;
        startWalking(SPEED);
    }
    /**
     * Sets the position of the ghost and updates its movement boundaries.
     *
     * @param position The new position of the ghost.
     */
    @Override
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }
    /**
     * Handles pre-step events, controlling the movement of the ghost within its range.
     *
     * @param stepEvent The step event.
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right){
            startWalking(-SPEED);
        }
        if (getPosition().x < left){
            startWalking(SPEED);
        }
    }
    /**
     * Handles post-step events.
     *
     * @param stepEvent The step event.
     */
    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
