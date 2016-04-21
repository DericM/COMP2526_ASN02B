package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.RandomGenerator;

import java.awt.Color;
import java.util.ArrayList;



@SuppressWarnings("serial")
public abstract class Aware extends Entity {

    protected ArrayList<Cell> prey;
    private ArrayList<Cell> pred;
    protected ArrayList<Cell> blank;
    protected ArrayList<Cell> mate;
    private ArrayList<Cell> obst;

    public Aware(Cell cell, Color cl) {
        super(cell, cl);
    }

    /**
     * Takes a turn for this Aware entity. 
     */
    public void takeTurn() {

        super.takeTurn();

        if (isAlive()) {
            evaluateSurroundings();

            procreate();
            

        }

    }

    /**
     * Pick a random cell from a list of cells.
     * 
     * @param cells the list to chose from.
     * 
     * @return the chosen cell.
     */
    public Cell pickCell(ArrayList<Cell> cells) {
        int index = RandomGenerator.nextNumber(cells.size());
        Cell cell = cells.get(index);
        cells.remove(index);
        return cell;
    }

    /**
     * Returns the most desirable adjacent cell.
     */
    public void evaluateSurroundings() {
        prey = new ArrayList<Cell>();
        pred = new ArrayList<Cell>();
        blank = new ArrayList<Cell>();
        mate = new ArrayList<Cell>();
        obst = new ArrayList<Cell>();

        ArrayList<Cell> adj = getCell().getAdjCells();
        
        for (Cell cell : adj) {
            
            //System.out.println(cell.getTile().getType());
            
            
            if (cell.getTile() == null) {
                blank.add(cell);
            } else if (cell.getTile().canEat(this)) {
                pred.add(cell);
            } else if (canEat(cell.getTile())) {
                prey.add(cell);
            } else if (mate(cell.getTile())) {
                mate.add(cell);
            } else {
                obst.add(cell);
            }
        }
    }

}
