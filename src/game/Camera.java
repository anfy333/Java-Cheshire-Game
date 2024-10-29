package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;
/**
 * Represents a camera that follows the movement of a character in the game.
 */
public class Camera implements StepListener {
    private GameView view;
    private Cat cheshire;
    private float x;
    private float y;
    private Vec2 cameraPos;
    /**
     * Constructs a camera that follows the specified Cat object in the given GameView.
     *
     * @param view     The GameView object.
     * @param cheshire The Cat object to follow.
     */
    public Camera(GameView view, Cat cheshire){
        x = cheshire.getPosition().x;
        y = cheshire.getPosition().y;
        this.cheshire = cheshire;
        this.view = view;
        cameraPos = view.getCentre();
    }
    /**
     * Updates the camera position before each step.
     *
     * @param e The StepEvent object.
     */
    public void preStep(StepEvent e) {
        float diffxL = Math.abs(x-cheshire.getPosition().x)-7;
        float diffxR = Math.abs(x-cheshire.getPosition().x);
        if (diffxR>0){
            if (cheshire.getPosition().x < x){
                x = x - diffxR;
                cameraPos = new Vec2(cameraPos.x-diffxR,cameraPos.y);
            }
            else if (diffxL>0){
                x = x + diffxL;
                cameraPos = new Vec2(cameraPos.x+diffxL,cameraPos.y);
            }
        }
        view.setCentre(cameraPos);

        float diffyUP = Math.abs(y-cheshire.getPosition().y)-10;
        float diffyD = Math.abs(y-cheshire.getPosition().y);
        if (diffyD>0){
            if (cheshire.getPosition().y < y){
                y = y - diffyD;
                cameraPos = new Vec2(cameraPos.x,cameraPos.y-diffyD);
            }
            else if(diffyUP>0){
                y = y + diffyUP;
                cameraPos = new Vec2(cameraPos.x,cameraPos.y+diffyUP);
            }
        }
        view.setCentre(cameraPos);

    }
    /**
     * Performs actions after each step.
     *
     * @param e The StepEvent object.
     */
    public void postStep(StepEvent e) {

    }
}
