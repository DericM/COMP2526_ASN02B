package ca.bcit.comp2526.a2b;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TurnListener extends MouseAdapter {

    
    GameFrame gameFrame;
    
    
    TurnListener(GameFrame gf) {
        gameFrame = gf;
    }
    
    
    public void mouseClicked(MouseEvent arg0) {
        gameFrame.takeTurn();

    }
}
