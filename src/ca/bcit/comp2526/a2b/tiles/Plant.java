package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.interfaces.EatenByHerbivore;

import java.awt.Color;

@SuppressWarnings("serial")
public class Plant extends Tile implements EatenByHerbivore {
    
    /** Randomly generated shade of green. */
    private static final Color defaultColor = Color.green;
    
    /**
     * Constructor.
     * @param c the cell to place the plant.
     */
    public Plant(Cell cell) {
        super(cell, newShade(defaultColor));
    }

    /**
     * Returns true if this tile can eat t.
     * @param t the tile to be eaten.
     */
    @Override
    public boolean eat(Tile tile) {
        return false;
    }

}
