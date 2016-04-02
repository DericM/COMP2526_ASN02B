package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.SpawnPool;

import java.awt.Color;

@SuppressWarnings("serial")
public class Omnivore extends Movable{

    /** Randomly generated shade of yellow. */
    private static final Color defaultColor = Color.orange;
    
    private static final int defaultLife = 10;
    /**
     * Constructor.
     * @param cell the cell to place the Carnivore inside of.
     */
    public Omnivore(Cell cell) {
        super(cell, defaultColor, defaultLife);
        setType(SpawnPool.OMNIVORE);
    }

    /**
     * Returns true if this tile can eat t.
     * @param t the tile to be eaten.
     */
    @Override
    public boolean canEat(Tile tile) {
        if(tile == null){
            return false;
        }
        if (tile.getType() == SpawnPool.HERBIVORE 
                || tile.getType() == SpawnPool.PLANT) {
            return true;
        }
        return false;
    }

    @Override
    public void procreate() {
        if(mate.size() >= 1 && blank.size() >= 3 && prey.size() >= 3) {
            SpawnPool.spawn(pickCell(blank), SpawnPool.OMNIVORE);
        }
    }
    
}
