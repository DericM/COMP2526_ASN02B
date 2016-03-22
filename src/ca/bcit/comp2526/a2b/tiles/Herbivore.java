package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.SpawnType;

import java.awt.Color;

@SuppressWarnings("serial")
public class Herbivore extends Movable {

    /** Randomly generated shade of yellow. */
    private static final Color defaultColor = Color.yellow;
    
    private static final int defaultLife = 10;
    
    /**
     * Constructor.
     * @param c the cell to place this herbivore.
     */
    public Herbivore(Cell cell) {
        super(cell, newShade(defaultColor), defaultLife);
        setType(SpawnType.HERBIVORE);
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
        if (tile.getType() == SpawnType.PLANT) {
            return true;
        }
        return false;
    }


    @Override
    public void procreate() {
        if(mate.size() >= 1 && blank.size() >= 1 && prey.size() >= 2) {
            SpawnType.spawnSingle(pickCell(blank), SpawnType.HERBIVORE);
        }
    }
}
