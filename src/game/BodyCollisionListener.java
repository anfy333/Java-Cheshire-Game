package game;
import city.cs.engine.CollisionListener;
import city.cs.engine.CollisionEvent;
/**
 * Represents a collision listener for ghosts in the game.
 */
public class BodyCollisionListener implements CollisionListener{
    private Cat cheshire;
    /**
     * Constructs a collision listener with the specified cat object.
     *
     * @param c The cat object.
     */
    public BodyCollisionListener(Cat c){
        this.cheshire = c;
    }
    /**
     * Handles collision events between bodies.
     *
     * @param e The collision event.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Cat) {
            if (cheshire.getHealth() > 0){
                cheshire.setHealth(cheshire.getHealth() - 20);
            }
            else{
                cheshire.setHealth(0);
            }
        }
    }
}

