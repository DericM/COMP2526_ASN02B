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
        super(cell, color, life);
        
    }

    /**
     * Takes a turn for this Movable tile. Moves the tile if it can. Remove the
     * tile if it is dead.
     * 
     * @return True if the tile moved, false if not.
     */
    public void takeTurn() {
        
        super.takeTurn();

        move();
        
        repaint();
    }
    
    
    
    /*
     * Moves the cell to a target cell.
     * 
     * @param target cell to move to.
     */
    private void move() {
        Cell target;
        if (prey.size() > 0) {
            target = pickCell(prey);
        }
        else if (blank.size() > 0) {
            target = pickCell(blank);
        }
        else {
            return;
        }
        
        if (canEat(target.getTile())) {
            resetLife();
            target.getTile().kill();
        }
        
        getCell().setTile(null);
        target.setTile(this);
        setCell(target);
    }
    

}
