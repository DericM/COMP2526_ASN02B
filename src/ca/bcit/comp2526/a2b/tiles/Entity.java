package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.SpawnPool;

import java.awt.Color;
import javax.swing.JPanel;

/**
 * Represents a Tile that is displayed on the grid. It has a color and a tile
 * that it is contained by.
 * 
 * @author Deric
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class Entity extends JPanel {

    /* The color of the Tile. */
    private Color color;

    private Color currentcolor;
    /* The Cell containing this Tile. */
    private Cell cell;

    private SpawnPool type;

    private boolean alive;

    /**
     * Constructor.
     * 
     * @param c
     *            the cell containing this tile.
     * @param cl
     *            the color of this tile.
     */
    Entity(Cell cell, Color cl) {
        color = currentcolor = cl;
        alive = true;
        setBackground(color);
        this.cell = cell;
        cell.setTile(this);
    }

    /**
     * change the color depending on the entities life.
     * @param maxLife the max life of the entity.
     * @param currentLife of the entity.
     */
    public void setColorByLife(int maxLife, int currentLife) {

        double power = currentLife;

        if (power > 15) {
            power = 15;
        }

        int red = (int) (color.getRed() * Math.pow(0.9, power));
        int green = (int) (color.getGreen() * Math.pow(0.9, power));
        int blue = (int) (color.getBlue() * Math.pow(0.9, power));
        currentcolor = new Color(red, green, blue);
        setBackground(currentcolor);
    }



    /**
     * Check if a Tile tile can be eaten.
     * 
     * @param tile
     *            the tile to be eaten.
     * @return True if the tile can be eaten, False if not.
     */
    public abstract boolean canEat(Entity tile);

    public abstract void procreate();

    /**
     * takes a turn for the entity.
     */
    public void takeTurn() {
        return;
    }

    /**
     * checks if the entity is alive.
     * @return alive or not.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * kills the entity.
     */
    public void kill() {
        alive = false;
    }

    /**
     * checks if the entity can mate with another entity..
     * @param tile the entity to mate with.
     * @return true or false.
     */
    public boolean mate(Entity tile) {
        if (type == tile.getType()) {
            return true;
        }
        return false;
    }

    /**
     * Set the new cell for this tile.
     * 
     * @param c
     *            the new cell containing this tile.
     */
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    /**
     * Get the cell containing this tile.
     * 
     * @return the cell containing this tile.
     */
    public Cell getCell() {
        return cell;
    }

    public void setType(SpawnPool type) {
        this.type = type;
    }

    public SpawnPool getType() {
        return type;
    }

}
