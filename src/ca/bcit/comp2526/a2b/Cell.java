package ca.bcit.comp2526.a2b;

import ca.bcit.comp2526.a2b.tiles.Tile;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


/**
 * Represents a Cell that is part of a grid in the world. It has column and a
 * row that determines its position on the grid. It contains a reference to the
 * world it is a part of. It can contain a tile.
 * 
 * @author Deric
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Cell extends JPanel {

    /** Cell column in the world. */
    private int col;
    /** Cell row in the world. */
    private int row;
    /** The world containing the cell. */
    private World world;
    /** The tile contained in the cell. */
    private Tile tile;

    
    private ArrayList<Cell> adj;
    
    
    
    
    
    
    /**
     * Construct a new cell.
     * 
     * @param c
     *            column of the cell in the world.
     * @param r
     *            row of the cell in the world.
     * @param w
     *            world containing the cell
     */
    Cell(int col, int row, World world) {
        this.col = col;
        this.row = row;
        this.world = world;
        tile = null;
    }

    /**
     * Sets up the layout and border of each cell.
     */
    public void init() {
        setLayout(new GridLayout(1, 1));
        setBorder(BorderFactory.createLineBorder(Color.black));
        adj = getAdjecentCells();
    }
    
    


    /*
     * Returns a list of adjacent tiles.
     * 
     * @return a list of the adjacent tiles.
     */
    private ArrayList<Cell> getAdjecentCells() {
        ArrayList<Cell> adj = new ArrayList<Cell>();
        Cell cell;

        for (int adjCol = col - 1; adjCol <= col + 1; adjCol++) {
            for (int adjRow = row - 1; adjRow <= row + 1; adjRow++) {
                if (cellExists(adjCol, adjRow)) {
                    cell = world.getCellAt(adjCol, adjRow);
                    adj.add(cell);
                }
            }
        }
        return adj;
    }




    /*
     * Check if cell at given coordinates is in the world and is not the current
     * cell.
     * 
     * @param row
     * 
     * @param col
     * 
     * @return True if cell exists, false if not.
     */
    private boolean cellExists(int col, int row) {
        return !(col < 0 
                || row < 0 
                || col >= world.getRowCount() 
                || row >= world.getColumnCount()
                || (col == this.col && row == this.row)
                );
    }

    /**
     * Return true if t can be eaten this cells tile.
     * 
     * @param ti
     *            the tile that will get eaten.
     * @return True if it can be eaten, False if not.
     */
    public boolean eat(Tile tile) {
        if (this.tile == null) {
            return false;
        }
        return this.tile.eat(tile);
    }

    /**
     * Returns the cells tile.
     * 
     * @return the cells tile.
     */
    public Tile getTile() {
        return tile;
    }

    /**
     * Set the cells tile, and add it to the JPanel.
     * 
     * @param ti
     *            the new tile to be set.
     */
    public void setTile(Tile ti) {
        removeAll();
        tile = ti;
        if (tile != null) {
            add(tile);
        }
        revalidate();
    }

    
    public ArrayList<Cell> getAdjCells(){
        return adj;
    }
    
    public World getWorld() {
        return world;
    }
    
    
    
    /**
     * Returns a Point with the coordinates of the cell.
     * 
     * @Return a Point with the coordinates of the cell.
     */
    public Point getLocation() {
        return new Point(col, row);
    }

}
