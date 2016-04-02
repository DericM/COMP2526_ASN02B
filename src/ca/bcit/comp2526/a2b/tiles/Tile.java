package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.RandomGenerator;
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
public abstract class Tile extends JPanel {

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
    Tile(Cell cell, Color cl) {
        color = currentcolor = cl;
        alive = true;
        setBackground(color);
        this.cell = cell;
        cell.setTile(this);
    }
    
            
    public void setColorByLife(int maxLife, int currentLife) {
        
        double power = currentLife;
        
        if(power > 15)
            power = 15;
        
        int red = (int)(color.getRed() * Math.pow(0.9, power));
        int green = (int)(color.getGreen() * Math.pow(0.9, power));
        int blue = (int)(color.getBlue() * Math.pow(0.9, power));
        currentcolor = new Color(red, green, blue);
        setBackground(currentcolor);
    }


    /**
     * Returns a random shade of color c.
     * 
     * @param cell
     *            Color to retrieve the shade from.
     * @return the new shade of color c.
     */
    public static Color newShade(Color color) {
        int red = randrgb(color.getRed(), 50);
        int green = randrgb(color.getGreen(), 50);
        int blue = randrgb(color.getBlue(), 50);
        return new Color(red, green, blue);
    }

    /**
     * Returns RGB number altered by a deviation range.
     * 
     * @param min
     *            the default RGB value.
     * @param deviation
     *            the maximum we can randomly alter the RGB value.
     * @return the altered RGB value.
     */
    private static int randrgb(int min, int deviation) {
        int rgb = min - deviation + 2 * RandomGenerator.nextNumber(deviation);
        if (rgb > 255) {
            return 255;
        }
        if (rgb < 0) {
            return 0;
        }
        return rgb;
    }


    

    
    
    /**
     * Check if a Tile tile can be eaten.
     * 
     * @param tile
     *            the tile to be eaten.
     * @return True if the tile can be eaten, False if not.
     */
    public abstract boolean canEat(Tile tile);
    
    public abstract void procreate();
    
    
    public void takeTurn(){
        return;
    }
    
    
    public boolean isAlive(){
        return alive;
    }
    
    
    public void kill(){
        alive = false;
    }
    
    
    
    
    public boolean mate(Tile tile){
        if(type == tile.getType()){
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
