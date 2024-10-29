package game;

import city.cs.engine.*;
/**
 * Represents a collision listener for mushroom pickups.
 */
public class MushroomPickup implements CollisionListener {
    private Cat cheshire;
    /**
     * Constructs a mushroom pickup collision listener with the specified cat instance.
     *
     * @param c The cat instance.
     */
    public MushroomPickup(Cat c){
        this.cheshire = c;
    }
    /**
     * Handles collision events between the cat and mushrooms.
     *
     * @param e The collision event.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Mushroom) {
            cheshire.setMushroomCount(cheshire.getMushrooms() + 1);
            e.getOtherBody().destroy();
        }

        }
}
