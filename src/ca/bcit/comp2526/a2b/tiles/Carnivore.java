package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.SpawnPool;

import java.awt.Color;

@SuppressWarnings("serial")
public class Carnivore extends Movable{

    /** Randomly generated shade of yellow. */
    private static final Color defaultColor = Color.magenta;
    
    private static final int defaultLife = 3;
    /**
     * Constructor.
     * @param cell the cell to place the Carnivore inside of.
     */
    public Carnivore(Cell cell) {
        super(cell, defaultColor, defaultLife);
        setType(SpawnPool.CARNIVORE);
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
                ||tile.getType() == SpawnPool.OMNIVORE) {
            return true;
        }
        return false;
    }

    @Override
    public void procreate() {
        if(mate.size() >= 1 && blank.size() >= 3 && prey.size() >= 3) {
            SpawnPool.spawn(pickCell(blank), SpawnPool.CARNIVORE);
        }
    }
    
}
