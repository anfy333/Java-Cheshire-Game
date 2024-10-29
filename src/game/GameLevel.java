package game;

import city.cs.engine.World;
/**
 * Represents a level in the game.
 */
public abstract class GameLevel extends World {
    private Cat cheshire;
    /**
     * Constructs a new GameLevel.
     * Creates a new instance of the Cat class for the level.
     */
    public GameLevel(){
        cheshire = new Cat(this);
    }
    /**
     * Retrieves the Cat character for this level.
     *
     * @return The Cat character for this level.
     */
    public Cat getCheshire() {
        return cheshire;
    }
    /**
     * Checks if the level is complete.
     *
     * @return True if the level is complete, otherwise false.
     */
    public abstract boolean isComplete();
    /**
     * Checks if the level is in a sleepy state (0 energy).
     *
     * @return True if the level is in a sleepy state, otherwise false.
     */
    public abstract boolean isSleepy();
}
