package game;

import city.cs.engine.*;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Represents an ivy that moves up and down and affects the cat's speed upon collision.
 */
public class Ivy extends StaticBody implements StepListener, CollisionListener, ActionListener {
    private static final Shape ivyShape = new BoxShape(2f, 1f);
    private float speed = 0.05f;
    private float direction = 1f; // 1 for moving up, -1 for moving down
    private Cat cheshire;
    private Timer timer;
    private boolean timerRunning = false;
    private float pos;
    private float range = 2.5F;
    /**
     * Sets the range of movement for the ivy.
     *
     * @param n The range value.
     */
    public void setRange(int n){range=n;}
    /**
     * Constructs an ivy with the specified parameters.
     *
     * @param world  The world in which the ivy exists.
     * @param cheshire The cat instance.
     * @param vec2   The initial position of the ivy.
     */
    public Ivy(World world, Cat cheshire, Vec2 vec2) {
        super(world, ivyShape);
        this.cheshire = cheshire;
        this.setPosition(vec2);
        pos = getPosition().y;
        addImage(new BodyImage("data/Tall_Vine.png", 8)); // Adjust the image size as needed
        world.addStepListener(this);
        timer = new Timer(10000, this);
    }

    /**
     * Performs actions before each step in the world.
     *
     * @param e The event associated with the step.
     */
    @Override
    public void preStep(StepEvent e) {
        // Move the Ivy up and down
        setPosition(getPosition().add(new Vec2(0, direction * speed)));
        // Change direction when reaching the upper or lower limit
        if (getPosition().y > pos+range || getPosition().y <= pos-1) {
            direction *= -1;
        }
    }

    /**
     * Performs actions after each step in the world.
     *
     * @param e The event associated with the step.
     */
    @Override
    public void postStep(StepEvent e) {
    }

    /**
     * Handles collision events with other bodies.
     *
     * @param e The collision event.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Cat) {
            timer.start();
            cheshire.setSpeed(3);
            timer.setRepeats(false);
            System.out.println(timer.isRunning());
            }
        }

    /**
     * Performs actions when the timer fires.
     *
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        cheshire.setSpeed(6);
        System.out.println("Timer running");
        }
    }





