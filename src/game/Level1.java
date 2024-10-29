package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;
/**
 * Represents the first level of the game.
 */
public class Level1 extends GameLevel{
    /**
     * Constructs Level1 with the specified game.
     *
     * @param game The game instance.
     */
    public Level1(Game game){
        super();
        Shape shape = new BoxShape(20, 1);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -18.5f));
        ground.setFillColor(Color.green);
        ground.addImage(new BodyImage("data/grass_3.png", 8.5f));

        // make a suspended platform
        Shape platformShape = new BoxShape(9.5f, 1);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-10.5f, -14));
        platform1.addImage(new BodyImage("data/grass_p1.png", 4));

        Shape platformShape1 = new BoxShape(7f, 1);
        StaticBody platform2 = new StaticBody(this, platformShape1);
        platform2.setPosition(new Vec2(13f, -8));
        platform2.addImage(new BodyImage("data/grass_p2.png", 4));

        Shape platformShape2 = new BoxShape(2, 1);
        StaticBody platform3 = new StaticBody(this, platformShape2);
        platform3.setPosition(new Vec2(-1, -1.5f));
        platform3.addImage(new BodyImage("data/grass_p3.png", 4));

        StaticBody platform4 = new StaticBody(this, platformShape1);
        platform4.setPosition(new Vec2(13f, 5.5f));
        platform4.addImage(new BodyImage("data/grass_p2.png", 4));

        Color transparent = new Color(1, 0, 0, 0);

        Shape borderShape = new BoxShape(0.5f, 30);
        StaticBody borderR = new StaticBody(this, borderShape);
        borderR.setPosition(new Vec2(23f, 0));
        borderR.setFillColor(transparent);
        borderR.setLineColor(transparent);

        StaticBody borderL = new StaticBody(this, borderShape);
        borderL.setPosition(new Vec2(-25f, 0));
        borderL.setFillColor(transparent);
        borderL.setLineColor(transparent);

        Ghost ghost1 = new Ghost(this,2);
        ghost1.setPosition(new Vec2(-10f,-13.5f));

        Ghost ghost2 = new Ghost(this,3);
        ghost2.setPosition(new Vec2(11f,7.5f));

        BodyCollisionListener bcl = new BodyCollisionListener(getCheshire());
        ghost1.addCollisionListener(bcl);
        ghost2.addCollisionListener(bcl);

        getCheshire().setPosition(new Vec2(5,-15.25f));

        Mushroom mush1 = new Mushroom(this);
        mush1.setPosition(new Vec2(-17f,-12f));

        Mushroom mush2 = new Mushroom(this);
        mush2.setPosition(new Vec2(15f,-6f));

        Mushroom mush3 = new Mushroom(this);
        mush3.setPosition(new Vec2(17f,7.5f));

        MushroomPickup pickup = new MushroomPickup(getCheshire());
        getCheshire().setBullets(0);
        getCheshire().addCollisionListener(pickup);
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
