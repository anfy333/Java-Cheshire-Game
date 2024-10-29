package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
/**
 * Represents the second level of the game.
 */
public class Level2 extends GameLevel {
    /**
     * Constructs Level2 with the specified game.
     *
     * @param game The game instance.
     */
    public Level2(Game game) {
        super();
        //ground
        this.setGravity(11);
        Shape shape = new BoxShape(30, 1);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -18.5f));
        ground.setFillColor(Color.green);
        ground.addImage(new BodyImage("data/grass_3.png", 8.5f));

        // platform with 1st flower
        Shape platformShape = new BoxShape(5f, 1);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(12.5f, -14));
        platform1.addImage(new BodyImage("data/grass_p4.png", 2.5f));
        //platform1.setAngleDegrees(-45);

        //platform 2
        Shape platformShape1 = new BoxShape(7f, 1);
        StaticBody platform2 = new StaticBody(this, platformShape1);
        platform2.setPosition(new Vec2(-5f, -6.5f));
        platform2.addImage(new BodyImage("data/grass_p2.png", 4));

        //platform 3 above indentical
        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(-4, 5));
        platform3.addImage(new BodyImage("data/grass_p4.png", 2.5f));

        //platform 4 small tiny
        Shape platformShape2 = new BoxShape(2, 1);
        StaticBody platform4 = new StaticBody(this, platformShape2);
        platform4.setPosition(new Vec2(-19, 0));
        platform4.addImage(new BodyImage("data/grass_p3.png", 4));

        //final platform 5 with 2nd flower
        StaticBody platform5 = new StaticBody(this, platformShape);
        platform5.setPosition(new Vec2(12.5f, 10));
        platform5.addImage(new BodyImage("data/grass_p4.png", 2.5f));

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

        //Projectile bullet = new Projectile(this);
        Flower flower1 = new Flower(this, getCheshire(), borderR, borderL);
        flower1.setPosition(new Vec2(12,-10.5f));
        Flower flower2 = new Flower(this, getCheshire(), borderR, borderL);
        flower2.setPosition(new Vec2(12,13.5f));

        Ivy ivy1 = new Ivy(this,getCheshire(),new Vec2(-7, -1));
        ivy1.addCollisionListener(ivy1);

        getCheshire().setPosition(new Vec2(-7,-15.25f));

        Mushroom mush1 = new Mushroom(this);
        mush1.setPosition(new Vec2(17f,-12f));

        Mushroom mush2 = new Mushroom(this);
        mush2.setPosition(new Vec2(-8f,-4.5f));

        Mushroom mush3 = new Mushroom(this);
        mush3.setPosition(new Vec2(-19,2));

        Mushroom mush4 = new Mushroom(this);
        mush4.setPosition(new Vec2(17,12));

        HealthPotion hp1 = new HealthPotion(this,getCheshire());
        hp1.addCollisionListener(hp1);
        hp1.setPosition(new Vec2(-4,7));

        MushroomPickup pickup = new MushroomPickup(getCheshire());
        getCheshire().addCollisionListener(pickup);
        getCheshire().setBullets(0);
        System.out.println(this.getGravity());
    }
    @Override
    public boolean isComplete() {
        if (getCheshire().getMushrooms() == 4)
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
