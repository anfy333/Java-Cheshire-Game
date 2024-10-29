package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Represents a projectile fired by the flower.
 */
public class Projectile extends DynamicBody implements CollisionListener {
    private static final CircleShape projectileShape = new CircleShape(0.5f);
    private Cat cheshire;
    StaticBody borderR;
    StaticBody borderL;
    /**
     * Constructs a projectile with the specified parameters.
     *
     * @param world    The world in which the projectile exists.
     * @param cheshire The cat instance firing the projectile.
     * @param borderR  The right border of the world.
     * @param borderL  The left border of the world.
     */
    public Projectile(World world, Cat cheshire, StaticBody borderR, StaticBody borderL) {
        super(world, projectileShape);
        addImage(new BodyImage("data/projectile.png", 1));
        this.cheshire = cheshire;
        this.borderR = borderR;
        this.borderL = borderL;

    }

    /**
     * Handles collision events involving the projectile.
     *
     * @param e The collision event.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Cat) {
            if (cheshire.getHealth() > 0) {
                System.out.println(cheshire.getHealth());
                cheshire.setHealth(cheshire.getHealth() - 10);
                System.out.println(cheshire.getHealth());
            } else {
                cheshire.setHealth(0);
            }
            destroy();
        }
        if (e.getOtherBody() == borderR || e.getOtherBody() == borderL){
            destroy();
        }
    }
}

