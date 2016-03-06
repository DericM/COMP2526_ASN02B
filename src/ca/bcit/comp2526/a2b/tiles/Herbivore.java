package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.interfaces.EatenByCarnivore;
import ca.bcit.comp2526.a2b.interfaces.EatenByHerbivore;

import java.awt.Color;


@SuppressWarnings("serial")
public class Herbivore extends Movable implements EatenByCarnivore {

    /** The default movements. */
    private static final int defaultMovement = 5;
    /** Randomly generated shade of yellow. */
    private static final Color defaultColor = Color.yellow;
    
    /**
     * Constructor.
     * @param c the cell to place this herbivore.
     */
    public Herbivore(Cell cell) {
        super(cell, newShade(defaultColor), defaultMovement);
    }
    

    /**
     * Returns true if this tile can eat t.
     * @param t the tile to be eaten.
     */
    @Override
    public boolean eat(Tile tile) {
        if (tile instanceof EatenByHerbivore) {
            return true;
        }
        return false;
    }
}
