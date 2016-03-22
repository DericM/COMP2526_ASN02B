package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.SpawnType;

import java.awt.Color;

@SuppressWarnings("serial")
public class Omnivore extends Movable{

    /** Randomly generated shade of yellow. */
    private static final Color defaultColor = Color.blue;
    
    private static final int defaultLife = 2;
    /**
     * Constructor.
     * @param cell the cell to place the Carnivore inside of.
     */
    public Omnivore(Cell cell) {
        super(cell, newShade(defaultColor), defaultLife);
        setType(SpawnType.OMNIVORE);
        life = defaultLife;
    }

    /**
     * Returns true if this tile can eat t.
     * @param t the tile to be eaten.
     */
    @Override
    public boolean eat(Tile tile) {
        if(tile == null){
            return false;
        }
        if (tile.getType() == SpawnType.HERBIVORE 
                || tile.getType() == SpawnType.CARNIVORE
                || tile.getType() == SpawnType.PLANT) {
            return true;
        }
        return false;
    }

    @Override
    public void procreate() {
        if(mate.size() >= 1 && blank.size() >= 3 && prey.size() >= 3) {
            SpawnType.spawnSingle(pickCell(blank), SpawnType.OMNIVORE);
        }
    }
    
}
