package ca.bcit.comp2526.a2b;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * GameFrame.
 * @author  BCIT
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GameFrame extends JFrame {
    private final World world;
    private Timer timer;

    public GameFrame(final World wo) {
        world = wo;
        timer = new Timer(50, new TurnTimer(this));
        timer.start();
    }

    /**
     * Initialize.
     */
    public void init() {
        setTitle("Assignment 2b");
        setLayout(new GridLayout(world.getRowCount(),
                                 world.getColumnCount()));

        for (int row = 0; row < world.getRowCount(); row++) {
            for (int col = 0; col < world.getColumnCount(); col++) {
                add(world.getCellAt(row, 
                                    col));
            }
        }

        addMouseListener(new TurnListener(this));
    }

    public void takeTurn() {
        world.takeTurn();
        repaint();
    }
}
