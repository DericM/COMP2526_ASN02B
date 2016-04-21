package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.SpawnPool;

import java.awt.Color;

@SuppressWarnings("serial")
public class Herbivore extends Movable {

    /** Randomly generated shade of yellow. */
    private static final Color defaultColor = Color.yellow;

    private static final int defaultLife = 10;

    /**
     * Constructor.
     * 
     * @param c
     *            the cell to place this herbivore.
     */
    public Herbivore(Cell cell) {
        super(cell, defaultColor, defaultLife);
        setType(SpawnPool.HERBIVORE);
    }

    /**
     * Returns true if this tile can eat t.
     * 
     * @param t
     *            the tile to be eaten.
     */
    @Override
    public boolean canEat(Entity tile) {
        if (tile == null) {
            return false;
        }
        if (tile.getType() == SpawnPool.PLANT) {
            return true;
        }
        return false;
    }

    @Override
    public void procreate() {
        if (mate.size() >= 1 && blank.size() >= 2 && prey.size() >= 3 && getLife() >= 5) {
            SpawnPool.spawn(pickCell(blank), SpawnPool.HERBIVORE);
        }
    }
}
