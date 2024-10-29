package game;

import city.cs.engine.BodyImage;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
/**
 * Controls the movement and actions of the Cat character in the game.
 * Implements the KeyListener interface to handle keyboard input.
 */
public class CatController implements KeyListener{
    Cat cheshire;
    World world;
    BodyImage gif = new BodyImage("data/CAT2 (4).gif", 4);
    BodyImage gifReverse = new BodyImage("data/CAT2 (4)reverse.gif", 4);
    BodyImage png = new BodyImage("data/CAT2.png", 4);
    BodyImage pngReverse = new BodyImage("data/CAT2reverse.png", 4);
    Boolean moveRight = true;
    /**
     * Constructs a CatController with the given Cat and World.
     *
     * @param cat   The Cat character to control.
     * @param world The World in which the Cat exists.
     */
    public CatController(Cat cat, World world) {
        cheshire = cat;
        this.world = world;
    }
    /**
     * Responds to key presses.
     *
     * @param e The KeyEvent representing the key press event.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        switch (e.getKeyCode()){
            case 65: {
                cheshire.removeAllImages();
                cheshire.addImage(gifReverse);
                cheshire.startWalking(-cheshire.getSpeed());
                moveRight = false; break;}
            case 68: {
                cheshire.removeAllImages();
                cheshire.addImage(gif);
                cheshire.startWalking(cheshire.getSpeed());
                moveRight = true; break;}
            case 32: {
                cheshire.jump(cheshire.getSpeed() + 5); break;
            }
            case 10: {
                shoot();
                break;
            }
        }
    }

    /**
     * Fires a bullet from the Cat character.
     * Checks if there are available bullets before firing.
     */
    private void shoot() {
        if (cheshire.getBullets() > 0){
            Bullet b = new Bullet(world, cheshire);
            System.out.println("bullet created");
            Vec2 direction;
            if (moveRight){
                direction = new Vec2(15, 0);
                b.setPosition(cheshire.getPosition().add(new Vec2(3.5f, 1)));
            } else{
                direction = new Vec2(-15, 0);
                b.setPosition(cheshire.getPosition().add(new Vec2(-3.5f, 1)));
            }

            b.setGravityScale(0f);
            b.addCollisionListener(b);
            b.setLinearVelocity(direction);
            System.out.println("bullet fired");
            cheshire.setBullets(cheshire.getBullets()-1);
            System.out.println(cheshire.getBullets());
        }
    }

    /**
     * Responds to key releases.
     *
     * @param e The KeyEvent representing the key release event.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 65: {
                cheshire.removeAllImages();
                cheshire.addImage(pngReverse);
                cheshire.startWalking(0);
                break;
            }
            case 68: {
                cheshire.removeAllImages();
                cheshire.addImage(png);
                cheshire.startWalking(0);
                break;
            }
        }

    }

    /**
     * Does nothing. Implemented from the KeyListener interface.
     *
     * @param e The KeyEvent representing the key typed event.
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
