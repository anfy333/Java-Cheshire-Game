package game;

import city.cs.engine.*;
/**
 * Represents a mushroom object in the game.
 */
public class Mushroom extends StaticBody {
    private static final Shape mushroomShape = new BoxShape(1f,1);

    private static BodyImage mushroomImage = new BodyImage("data/mushroom.png", 2);
    /**
     * Constructs a mushroom object in the specified world.
     *
     * @param world The world to add the mushroom to.
     */
    public Mushroom(World world){
        super (world, mushroomShape);
        addImage(mushroomImage);
    }
}
