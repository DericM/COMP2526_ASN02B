package ca.bcit.comp2526.a2b.tiles;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.RandomGenerator;

@SuppressWarnings("serial")
public abstract class Living extends Tile{

    private boolean alive;
    
    protected int life;
    
    protected ArrayList<Cell> prey;
    protected ArrayList<Cell> pred;
    protected ArrayList<Cell> blank;
    protected ArrayList<Cell> mate;
    
    private JLabel label;
    
    Living(Cell cell, Color color) {
        super(cell, color);
        alive = true;
        label = new JLabel();
        label.setFont(new Font("sans-Serif", Font.PLAIN, 10));
        printLable();
        add(label);
    }
    
    
    
    public void takeTurn(){
        life--;
        System.out.println(life);
        if(life < 0){
            kill();
            return;
        }
        evaluateSurroundings();
        
        procreate();
        
        printLable();
    }
    
    
    /*
     * Prints a basic label onto the tiles for testing.
     */
    public void printLable() {
        
        label.setText("" + life + "-" + (int) getCell().getLocation().getY() + ","
                + (int) getCell().getLocation().getX());
    }
    
    
    
    /**
     * Returns the most desirable adjacent cell.
     * 
     * @return the most desirable cell.
     */
    public void evaluateSurroundings() {
        ArrayList<Cell> adj = getCell().getAdjCells();
        prey = new ArrayList<Cell>();
        pred = new ArrayList<Cell>();
        blank = new ArrayList<Cell>();
        mate = new ArrayList<Cell>();

        for (Cell cell : adj) {
            if (cell.getTile() == null) {
                blank.add(cell);
            } else if (cell.eat(this)) {
                pred.add(cell);
            } else if (eat(cell.getTile())) {
                prey.add(cell);
            } else if (mate(cell.getTile())){
                mate.add(cell);
            }
            else {
                ;
            }
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
        if (cells == null) {
            return null;
        }
        return cells.get(RandomGenerator.nextNumber(cells.size()));
    }
    
    
    
    public abstract void procreate();
    
    

    
    
    
    
    public boolean isAlive(){
        return alive;
    }
    
    public void setStatus(boolean living){
        alive = living;
    }
    
    public void kill(){
        alive = false;
    }
    
    public void setLife(int life){
        this.life = life;
    }
    
    public int getLife(){
        return life;
    }
    


}
