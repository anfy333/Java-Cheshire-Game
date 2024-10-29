package game;
import city.cs.engine.*;
/**
 * Represents the main character of the game, a Cat.
 */
public class Cat extends Walker{
    private static final Shape catShape = new PolygonShape(-2.6f,1.99f, 2.58f,2.0f,
            2.6f,0.25f, 1.86f,-1.95f,
            -1.38f,-1.95f, -2.61f,0.0f);

    private static BodyImage catImage = new BodyImage("data/CAT2.png", 4);
    private static int mushroomCount = 0;
    private static int health = 100;
    private static int bullets = 0;
    private static int speed = 9;
    /**
     * Sets the count of mushrooms collected by the Cat.
     *
     * @param count The count of mushrooms to set.
     */
    public static void setMushroomCount(int count){
        mushroomCount = count;
    }
    /**
     * Gets the count of mushrooms collected by the Cat.
     *
     * @return The count of mushrooms collected.
     */
    public static int getMushrooms(){
        return mushroomCount;
    }
    /**
     * Sets the health of the Cat.
     *
     * @param count The health value to set.
     */
    public static void setHealth(int count){
        health = count;
    }
    /**
     * Gets the health of the Cat.
     *
     * @return The health of the Cat.
     */
    public static int getHealth(){
        return health;
    }
    /**
     * Sets the count of bullets possessed by the Cat.
     *
     * @param count The count of bullets to set.
     */
    public static void setBullets(int count){bullets = count;}
    /**
     * Gets the count of bullets possessed by the Cat.
     *
     * @return The count of bullets possessed.
     */
    public static int getBullets(){return bullets;}
    /**
     * Sets the speed of the Cat.
     *
     * @param s The speed value to set.
     */
    public static void setSpeed(int s){
        speed = s;
    }
    /**
     * Gets the speed of the Cat.
     *
     * @return The speed of the Cat.
     */
    public static int getSpeed(){ return speed;}
    /**
     * Constructs a Cat with the given World.
     *
     * @param world The World in which the Cat exists.
     */
    public Cat(World world){
        super (world, catShape);
        addImage(catImage);
    }
}