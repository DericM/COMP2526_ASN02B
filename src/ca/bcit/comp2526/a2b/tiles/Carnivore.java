package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.SpawnType;

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
        super(cell, newShade(defaultColor), defaultLife);
        setType(SpawnType.CARNIVORE);
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
        if (tile.getType() == SpawnType.HERBIVORE) {
            return true;
        }
        return false;
    }

    @Override
    public void procreate() {
        if(mate.size() >= 1 && blank.size() >= 3 && prey.size() >= 3) {
            SpawnType.spawnSingle(pickCell(blank), SpawnType.CARNIVORE);
        }
    }
    
}
