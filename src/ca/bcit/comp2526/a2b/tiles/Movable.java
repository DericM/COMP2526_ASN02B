package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;

import java.awt.Color;

/**
 * Represents a Tile that is capable of movement. It has a number of movements
 * allocated to it.
 * 
 * @author Deric
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class Movable extends Living {

    private int refill;
    /** Label to display life and location. */
    

    /**
     * Constructor.
     * 
     * @param c
     *            the cell to be passed to the Tile constructor.
     * @param cl
     *            the color to be passed to the Tile constructor.
     * @param l
     *            the number of life points.
     */
    Movable(Cell cell, Color color, int life) {
        super(cell, color);
        refill = life;
        
    }

    /**
     * Takes a turn for this Movable tile. Moves the tile if it can. Remove the
     * tile if it is dead.
     * 
     * @return True if the tile moved, false if not.
     */
    public void takeTurn() {
        super.takeTurn();
        System.out.println(life);
        Cell target = targetCell();

        if (target != null) {
            if (eat(target.getTile())) {
                life = refill;
                ((Living) target.getTile()).kill();
            }
            move(target);
            
        }
        printLable();
        
    }



    
    
    /**
     * Returns the most desirable adjacent cell.
     * 
     * @return the most desirable cell.
     */
    public Cell targetCell() {
        if (prey.size() != 0) {
            return pickCell(prey);
        }
        if (blank.size() != 0) {
            return pickCell(blank);
        }

        return null;
    }
    

    
    
    /*
     * Moves the cell to a target cell.
     * 
     * @param target cell to move to.
     */
    private void move(Cell target) {
        getCell().setTile(null);
        target.setTile(this);
        setCell(target);
    }
    

}
