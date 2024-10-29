package game;

import city.cs.engine.*;
/**
 * Represents a bullet fired by the Cat.
 */
public class Bullet extends DynamicBody implements CollisionListener {
    private static final CircleShape bulletShape = new CircleShape(0.5f);
    private Cat cheshire;
    /**
     * Constructs a bullet in the specified world, associated with the given Cat object.
     *
     * @param world    The world to add the bullet to.
     * @param cheshire The Cat object that fired the bullet.
     */
    public Bullet(World world, Cat cheshire) {
        super(world, bulletShape);
        addImage(new BodyImage("data/bullet.png", 1));
        this.cheshire = cheshire;
        //this.borderR = borderR;
        //this.borderL = borderL;
    }
    /**
     * Handles collisions involving the bullet.
     *
     * @param e The CollisionEvent object representing the collision.
     */
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Cat) {
            cheshire.setBullets(cheshire.getBullets() + 3);
            destroy();
            System.out.println(cheshire.getBullets());
        } else if (e.getOtherBody() instanceof Ghost) {
            Ghost ghost = (Ghost) e.getOtherBody();
            System.out.println("collided");
            System.out.println(ghost.getHealth());
            if (ghost.getHealth() > 25) {
                destroy();
                ghost.setHealth(ghost.getHealth() - 25);
                System.out.println(ghost.getHealth());
            } else {
                destroy();
                e.getOtherBody().destroy();
            }
        }
    }
}
