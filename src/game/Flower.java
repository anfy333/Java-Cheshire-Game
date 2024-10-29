package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Represents a flower that shoots projectiles.
 */
public class Flower extends StaticBody implements StepListener{
        private static final BodyImage flowerImage = new BodyImage("data/flower.gif", 7f);
        private static final Shape flowerShape = new PolygonShape(0.43f,1.89f, 2.07f,-0.39f,
                2.03f,-3.47f, -1.4f,-3.43f,
                -1.49f,1.05f);
        //private static DynamicBody Projectile;
        private static final float bulletSpeed = 10f;
        private static final float bulletInterval = 1f;
        private float shootTimer = 0f;
        private Cat cheshire;
        private StaticBody borderR;
        private StaticBody borderL;
    /**
     * Constructs a flower with the specified parameters.
     *
     * @param world    The world in which the flower exists.
     * @param cheshire The cat instance.
     * @param borderR  The right border of the world.
     * @param borderL  The left border of the world.
     */
        public Flower(World world, Cat cheshire, StaticBody borderR, StaticBody borderL) {
            super(world, flowerShape);
            addImage(flowerImage);
            world.addStepListener(this);
            //this.Projectile = Projectile;
            this.cheshire = cheshire;
            this.borderR = borderR;
            this.borderL = borderL;
        }

    /**
     * Performs actions before each step in the world.
     *
     * @param stepEvent The event associated with the step.
     */
        @Override
        public void preStep(StepEvent stepEvent) {
        }

    /**
     * Performs actions after each step in the world.
     *
     * @param stepEvent The event associated with the step.
     */
        @Override
        public void postStep(StepEvent stepEvent) {
            shootTimer += stepEvent.getStep();

            // Shoot a projectile at regular intervals
            if (shootTimer >= bulletInterval) {
                shoot();
                shootTimer = -1f;
            }

        }
    /**
     * Shoots a projectile from the flower.
     */
    private void shoot() {
        Projectile projectile = new Projectile(getWorld(),cheshire,borderR,borderL);
        cheshire.addCollisionListener(projectile);
        projectile.addCollisionListener(projectile);
        projectile.setPosition(getPosition().add(new Vec2(-1, 2)));

        // Setting the direction of the projectile
        Vec2 direction = new Vec2(-15, 0);

        // Applying linear velocity to the projectile
        projectile.setGravityScale(0f);
        projectile.setLinearVelocity(direction);
    }
    }


