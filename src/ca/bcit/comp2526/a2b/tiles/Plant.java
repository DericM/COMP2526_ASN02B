package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.SpawnType;

import java.awt.Color;

@SuppressWarnings("serial")
public class Plant extends Living {
    
    /** Randomly generated shade of green. */
    private static final Color defaultColor = Color.green;
    
    private static final int defaultLife = 10;
    
    /**
     * Constructor.
     * @param c the cell to place the plant.
     */
    public Plant(Cell cell) {
        super(cell, newShade(defaultColor));
        setType(SpawnType.HERBIVORE);
        
        life = defaultLife;
        
    }

    /**
     * Returns true if this tile can eat t.
     * @param t the tile to be eaten.
     */
    @Override
    public boolean eat(Tile tile) {
        return false;
    }

    @Override
    public void procreate() {
        if(mate.size() >= 3 && blank.size() >= 2) {
            SpawnType.spawnSingle(pickCell(blank), SpawnType.PLANT);
        }
    }




}
