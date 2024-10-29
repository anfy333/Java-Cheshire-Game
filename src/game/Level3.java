package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;
/**
 * Represents the third level of the game.
 */
public class Level3 extends GameLevel{
    Ghost ghost1, ghost2;
    /**
     * Constructs Level3 with the specified game.
     *
     * @param game The game instance.
     */
    public Level3(Game game){
        super();
        this.setGravity(11);
        //ground
        Shape shape = new BoxShape(30, 1);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -18.5f));
        ground.setFillColor(Color.green);
        ground.addImage(new BodyImage("data/grass_3.png", 8.5f));

        //platform 1 tiny small
        Shape platformShape2 = new BoxShape(2, 1);
        StaticBody platform1 = new StaticBody(this, platformShape2);
        platform1.setPosition(new Vec2(14, -13));
        platform1.addImage(new BodyImage("data/grass_p3.png", 4));

        //platform 2 & 3 together long
        Shape platformShape1 = new BoxShape(7f, 1);
        StaticBody platform2 = new StaticBody(this, platformShape1);
        platform2.setPosition(new Vec2(-0.5f, -9f));
        platform2.addImage(new BodyImage("data/grass_p2.png", 4));
        Shape platformShape = new BoxShape(5f, 1);
        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(-9f, -9));
        platform3.addImage(new BodyImage("data/grass_p4.png", 2.5f));

        //platform 4 & 5 tiny
        StaticBody platform4 = new StaticBody(this, platformShape2);
        platform4.setPosition(new Vec2(-18, -2));
        platform4.addImage(new BodyImage("data/grass_p3.png", 4));
        StaticBody platform5 = new StaticBody(this, platformShape2);
        platform5.setPosition(new Vec2(-20.5f, -2));
        platform5.addImage(new BodyImage("data/grass_p3.png", 4));

        //platform 6 longish with flower
        StaticBody platform6 = new StaticBody(this, platformShape1);
        platform6.setPosition(new Vec2(-0.5f, 0f));
        platform6.addImage(new BodyImage("data/grass_p2.png", 4));

        Color transparent = new Color(1, 0, 0, 0);

        //border right
        Shape borderShape = new BoxShape(0.5f, 30);
        StaticBody borderR = new StaticBody(this, borderShape);
        borderR.setPosition(new Vec2(25f, 0));
        borderR.setFillColor(transparent);
        borderR.setLineColor(transparent);

        //border left
        StaticBody borderL = new StaticBody(this, borderShape);
        borderL.setPosition(new Vec2(-25f, 0));
        borderL.setFillColor(transparent);
        borderL.setLineColor(transparent);

        BodyCollisionListener bcl = new BodyCollisionListener(getCheshire());
        ghost1 = new Ghost(this,3);
        ghost1.setRANGE(7);
        ghost1.setHealth(100);
        ghost1.setPosition(new Vec2(2,-14.5f));
        ghost1.addCollisionListener(bcl);

        ghost2 = new Ghost(this,3);
        ghost2.setRANGE(1);
        ghost2.setHealth(100);
        ghost2.setPosition(new Vec2(-12,-7f));
        ghost2.addCollisionListener(bcl);

        Bullet b1 = new Bullet(this, getCheshire());
        b1.setPosition(new Vec2(-13,-16.5f));
        Bullet b2 = new Bullet(this, getCheshire());
        b2.setPosition(new Vec2(-11.5f,-16.5f));
        Bullet b3 = new Bullet(this, getCheshire());
        b3.setPosition(new Vec2(-10f,-16.5f));
        Bullet b4 = new Bullet(this, getCheshire());
        b4.setPosition(new Vec2(-8.5f,-16.5f));
        Bullet b5 = new Bullet(this, getCheshire());
        b5.setPosition(new Vec2(-2f,-7f));
        Bullet b6 = new Bullet(this, getCheshire());
        b6.setPosition(new Vec2(-0.5f,-7f));
        Bullet b7 = new Bullet(this, getCheshire());
        b7.setPosition(new Vec2(1f,-7f));
        Bullet b8 = new Bullet(this, getCheshire());
        b8.setPosition(new Vec2(2.5f,-7f));

        b1.setGravityScale(0);
        b2.setGravityScale(0);
        b3.setGravityScale(0);
        b4.setGravityScale(0);
        b5.setGravityScale(0);
        b6.setGravityScale(0);
        b7.setGravityScale(0);
        b8.setGravityScale(0);

        b1.addCollisionListener(b1);
        b2.addCollisionListener(b2);
        b3.addCollisionListener(b3);
        b4.addCollisionListener(b4);
        b5.addCollisionListener(b5);
        b6.addCollisionListener(b6);
        b7.addCollisionListener(b7);
        b8.addCollisionListener(b8);

        Flower flower1 = new Flower(this, getCheshire(), borderR, borderL);
        flower1.setPosition(new Vec2(-0.5f,3.5f));

        Ivy ivy1 = new Ivy(this,getCheshire(),new Vec2(2, -4));
        ivy1.setRange(1);
        ivy1.addCollisionListener(ivy1);

        Mushroom mush1 = new Mushroom(this);
        mush1.setPosition(new Vec2(14f,-11f));
        Mushroom mush2 = new Mushroom(this);
        mush2.setPosition(new Vec2(-18,0));
        Mushroom mush3 = new Mushroom(this);
        mush3.setPosition(new Vec2(4,2));

        MushroomPickup pickup = new MushroomPickup(getCheshire());
        getCheshire().addCollisionListener(pickup);
        getCheshire().setPosition(new Vec2(-16,-15.25f));
        System.out.println(this.getGravity());
    }
    @Override
    public boolean isComplete() {
        if (getCheshire().getMushrooms() == 3)
            return true;
        else return false;
    }
    @Override
    public boolean isSleepy() {
        if (getCheshire().getHealth() == 0)
            return true;
        else return false;
    }
}
