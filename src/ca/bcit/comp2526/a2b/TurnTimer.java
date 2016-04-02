package ca.bcit.comp2526.a2b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurnTimer implements ActionListener {

    
    GameFrame gameFrame;
    
    
    TurnTimer(GameFrame gf) {
        gameFrame = gf;
    }
    



    @Override
    public void actionPerformed(ActionEvent arg0) {
        gameFrame.takeTurn();
    }
}
