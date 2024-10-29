package game;

import city.cs.engine.*;
/**
 * Represents a health potion that restores the cat's health upon collision.
 */
public class HealthPotion extends StaticBody implements CollisionListener{
    private static final Shape healthShape = new BoxShape(1f,1);
    private Cat cheshire;
    private static BodyImage healthImage = new BodyImage("data/hp.png", 2);
    /**
     * Constructs a health potion with the specified parameters.
     *
     * @param world    The world in which the health potion exists.
     * @param cheshire The cat instance.
     */
    public HealthPotion(World world, Cat cheshire){
        super (world, healthShape);
        this.cheshire = cheshire;
        addImage(healthImage);
    }

    /**
     * Handles collision events with other bodies.
     *
     * @param e The collision event.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Cat) {
            if (cheshire.getHealth() <= 80) {
                cheshire.setHealth(cheshire.getHealth() + 20);
            }
            else{
                cheshire.setHealth(100);
            }
            destroy();
        }

    }
}
