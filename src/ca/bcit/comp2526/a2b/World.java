package ca.bcit.comp2526.a2b;

import ca.bcit.comp2526.a2b.tiles.Entity;

import java.util.ArrayList;

/**
 * Represents a World that contains a grid of Cells. Contains a list of movable
 * tiles that are in the Cells on the grid. Contains cols and rows which
 * represent the size of the grid.
 * 
 * @author Deric
 * @version 1.0
 */
public class World {

    /* The number of columns in the grid */
    private int cols;
    /* The number of rows in the grid */
    private int rows;
    /* A grid of cells that can contain tiles. */
    private Cell[][] cells;
    /* A List of movable entities contained by cells in the grid. */
    private ArrayList<Entity> takesTurns;

    /**
     * builds a new world with a width and height.
     * 
     * @param width
     *            columns in the world.
     * @param height
     *            rows in the world.
     */
    World(int width, int height) {
        cols = width;
        rows = height;
        cells = new Cell[cols][rows];
        takesTurns = new ArrayList<Entity>();
    }

    /**
     * Initialize the world, creates cells, spawns Tiles.
     */
    public void init() {
        SpawnPool.init(takesTurns);
        Cell cell;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cell = new Cell(i, j, this);
                cells[i][j] = cell;
                SpawnPool.spawnRand(cell);
            }
        }
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cells[i][j].init();
            }
        }

    }

    /*
     * Gets all the empty cells and pick one at random.
     * 
     * @return the random empty cell.
     */
    private Cell getRandomEmptyCell() {
        ArrayList<Cell> empty = new ArrayList<Cell>();
        Cell cell;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cell = cells[i][j];
                if (cell.getTile() == null) {
                    empty.add(cell);
                }
            }
        }
        return empty.get(RandomGenerator.nextNumber(empty.size()));
    }

    /**
     * Returns a cell at a specified row and column.
     * 
     * @param col
     *            to return.
     * @param row
     *            to return.
     * @return the cell at the specified location.
     */
    public Cell getCellAt(int col, int row) {
        return cells[col][row];
    }

    /**
     * Takes a turn for every entity, if the entity dosn't move, then we remove
     * it from the list.
     */
    public void takeTurn() {
        Entity liv;
        int size;

        for (int i = 0; i < takesTurns.size(); i++) {
            liv = takesTurns.get(i);
            if (!liv.isAlive()) {
                System.out.println("---------" + takesTurns.size());
                takesTurns.remove(i);
                i--;
                liv.getCell().setTile(null);
            }
        }

        size = takesTurns.size();
        for (int i = 0; i < size; i++) {
            liv = takesTurns.get(i);
            if (!liv.isAlive()) {
                System.out.println("---------" + takesTurns.size());
                takesTurns.remove(i);
                liv.getCell().setTile(null);
                size--;
            } else {
                liv.takeTurn();
            }
        }
        if (takesTurns.size() < 625) {
            SpawnPool.spawnRand(getRandomEmptyCell());
            System.out.println("+++++New Entity+++++" + takesTurns.size());
        }
        
        
    }

    /**
     * returns the number of rows.
     * 
     * @return the number of rows in the grid.
     */
    public int getRowCount() {
        return rows;
    }

    /**
     * returns the number of columns.
     * 
     * @return the number of cols in the grid.
     */
    public int getColumnCount() {
        return cols;
    }
}
