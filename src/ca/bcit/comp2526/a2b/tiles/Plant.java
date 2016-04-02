package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.SpawnPool;

import java.awt.Color;

@SuppressWarnings("serial")
public class Plant extends Living {
    
    /** Randomly generated shade of green. */
    private static final Color defaultColor = Color.green;
    
    private static final int defaultLife = 1;
    
    /**
     * Constructor.
     * @param c the cell to place the plant.
     */
    public Plant(Cell cell) {
        super(cell, defaultColor, defaultLife);
        setType(SpawnPool.PLANT);
        setGrowth(-1);
    }

    /**
     * Returns true if this tile can eat t.
     * @param t the tile to be eaten.
     */
    @Override
    public boolean canEat(Tile tile) {
        return false;
    }

    
    @Override
    public void procreate() {
        if(mate.size() >= 1 && blank.size() >= 3 && getLife() >= 10) {
            SpawnPool.spawn(pickCell(blank), SpawnPool.PLANT);
        }
    }
}
