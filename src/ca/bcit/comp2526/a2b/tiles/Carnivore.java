package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.interfaces.EatenByCarnivore;

import java.awt.Color;

@SuppressWarnings("serial")
public class Carnivore extends Movable{

    /** The default movements. */
    private static final int defaultMovement = 5;
    /** Randomly generated shade of yellow. */
    private static final Color defaultColor = Color.red;
    
    /**
     * Constructor.
     * @param cell the cell to place the Carnivore inside of.
     */
    public Carnivore(Cell cell) {
        super(cell, newShade(defaultColor), defaultMovement);
    }

    /**
     * Returns true if this tile can eat t.
     * @param t the tile to be eaten.
     */
    @Override
    public boolean eat(Tile tile) {
        if (tile instanceof EatenByCarnivore) {
            return true;
        }
        return false;
    }
    
}
