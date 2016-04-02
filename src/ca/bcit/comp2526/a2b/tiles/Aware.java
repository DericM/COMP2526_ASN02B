package ca.bcit.comp2526.a2b.tiles;

import java.awt.Color;
import java.util.ArrayList;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.RandomGenerator;

@SuppressWarnings("serial")
public abstract class Aware extends Tile{

    
    protected ArrayList<Cell> prey;
    private   ArrayList<Cell> pred;
    protected ArrayList<Cell> blank;
    protected ArrayList<Cell> mate;
    private   ArrayList<Cell> obst;
    
    
    public Aware(Cell cell, Color cl) {
        super(cell, cl);
    }
    
    public void takeTurn(){
        
        super.takeTurn();
        
        if(isAlive()){
            evaluateSurroundings();
            
            procreate();
            evaluateSurroundings();
            
        }
        
    }
    
    /*
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
     * 
     * @return the most desirable cell.
     */
    private void evaluateSurroundings() {
        ArrayList<Cell> adj = getCell().getAdjCells();
        prey = new ArrayList<Cell>();
        pred = new ArrayList<Cell>();
        blank = new ArrayList<Cell>();
        mate = new ArrayList<Cell>();
        obst = new ArrayList<Cell>();

        for (Cell cell : adj) {
            if (cell.getTile() == null) {
                blank.add(cell);
            } else if (cell.getTile().canEat(this)) {
                pred.add(cell);
            } else if (canEat(cell.getTile())) {
                prey.add(cell);
            } else if (mate(cell.getTile())){
                mate.add(cell);
            }
            else {
                obst.add(cell);
            }
        }
    }
    
    public void removeBlank(Cell cell){
        blank.remove(blank.indexOf(cell));
    }
    
}
