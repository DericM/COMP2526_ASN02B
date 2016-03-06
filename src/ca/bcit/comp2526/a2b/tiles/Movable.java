package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * Represents a Tile that is capable of movement. It has a number of movements
 * allocated to it.
 * 
 * @author Deric
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class Movable extends Tile {

    /** The number of movements remaining. */
    private int movement;

    /** Label to display life and location. */
    private JLabel label;

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
    Movable(Cell cell, Color cl, int moves) {
        super(cell, cl);
        movement = moves;
        label = new JLabel();
        printLable();
        add(label);
    }

    /**
     * Takes a turn for this Movable tile. Moves the tile if it can. Remove the
     * tile if it is dead.
     * 
     * @return True if the tile moved, false if not.
     */
    public boolean takeTurn() {
        Cell target = getCell().targetCell();
        if (movement <= 0) {
            removeThis();
            return false;
        } else if (target == null) {
            ;// wait a turn
        } else {
            if (getCell().tileCanEat(target.getTile())) {
                movement = 6;
            }
            move(target);
        }
        movement--;
        printLable();
        return true;
    }

    /*
     * Prints a basic label onto the tiles for testing.
     */
    private void printLable() {
        label.setText("(" + movement + ") \n" + (int) getCell().getLocation().getY() + ","
                + (int) getCell().getLocation().getX());
    }

    /*
     * Removes this tile from its cell.
     */
    private void removeThis() {
        getCell().setTile(null);
        setCell(null);
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
