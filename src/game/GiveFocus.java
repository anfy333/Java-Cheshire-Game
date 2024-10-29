package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * A mouse adapter class that focuses on the component when the mouse enters it.
 */
public class GiveFocus extends MouseAdapter {
    /**
     * Called when the mouse enters the component.
     * Requests focus on the component.
     *
     * @param e The mouse event associated with the mouse entering the component.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        e.getComponent().requestFocus();
    }

}
