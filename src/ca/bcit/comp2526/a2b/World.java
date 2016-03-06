package ca.bcit.comp2526.a2b;

import java.util.ArrayList;

import ca.bcit.comp2526.a2b.tiles.Carnivore;
import ca.bcit.comp2526.a2b.tiles.Herbivore;
import ca.bcit.comp2526.a2b.tiles.Movable;
import ca.bcit.comp2526.a2b.tiles.Plant;

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
    /* A List of movable tiles contained by cells in the grid. */
    private ArrayList<Movable> moveable;

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
        moveable = new ArrayList<Movable>();
    }

    /**
     * Initialize the world, creates cells, spawns Tiles.
     */
    public void init() {
        Cell cell;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cell = new Cell(i, j, this);
                cells[i][j] = cell;
                cell.init();
                spawn(cell);
            }
        }
    }

    /*
     * Spawns a Random tile. See SpawnType for spawn rates.
     * 
     * @param c the cell in which to spawn the tile.
     */
    private void spawn(Cell cell) {
        switch (SpawnType.spawn()) {
          case PLANT:
              new Plant(cell);
              break;
          case HERBIVORE:
              moveable.add(new Herbivore(cell));
              break;
          case CARNIVORE:
              moveable.add(new Carnivore(cell));
              break;
          default:
              break;// blank
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
     * Takes a turn for every movable, if the movable dosn't move, then we
     * remove it from the movable list.
     */
    public void takeTurn() {
        Movable mov;
        for (int i = 0; i < moveable.size(); i++) {
            mov = moveable.get(i);
            if (mov == null || !mov.takeTurn()) {
                moveable.remove(i);
            }
        }
        spawn(getRandomEmptyCell());
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
