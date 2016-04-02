package ca.bcit.comp2526.a2b.tiles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import ca.bcit.comp2526.a2b.Cell;

@SuppressWarnings("serial")
public abstract class Living extends Aware{

    private int maxLife;
    
    private int currentLife;
    
    private int growth;
    
    private JLabel label;
    
    
    Living(Cell cell, Color color, int life) {
        super(cell, color);
        maxLife = currentLife = life;
        growth = 1;
        label = new JLabel();
        label.setFont(new Font("sans-Serif", Font.PLAIN, 20));
        printLable();
        add(label);
    }
    
    
    
    public void takeTurn(){
        super.takeTurn();
        
        currentLife -= growth;
        
        if(currentLife <= 0){
            kill();
        }
        
        
        printLable();
        setColorByLife(maxLife, currentLife);
    }
    
    

    
    
    /*
     * Prints a basic label onto the tiles for testing.
     */
    private void printLable() {
        
        label.setText("" + currentLife + ""); 
             //   + (int) getCell().getLocation().getY() + ","
              //  + (int) getCell().getLocation().getX());
    }

    
    
    
    public void resetLife(){
        currentLife = maxLife;
    }
    
    

    
    public void setLife(int life){
        currentLife = life;
    }
    
    public int getLife(){
        return currentLife;
    }
    
    public void setGrowth(int change){
        growth = change;
    }
    


}
