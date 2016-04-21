package ca.bcit.comp2526.a2b.tiles;

import ca.bcit.comp2526.a2b.Cell;
import ca.bcit.comp2526.a2b.SpawnPool;

import java.awt.Color;

@SuppressWarnings("serial")
public class Water extends Aware {

    private static final Color defaultColor = Color.blue;

    public Water(Cell cell) {
        super(cell, defaultColor);
        setType(SpawnPool.WATER);
    }

    @Override
    public boolean canEat(Entity tile) {
        return false;
    }

    @Override
    public void procreate() {
        if (blank.size() >= 1) {
            SpawnPool.spawn(pickCell(blank), SpawnPool.PLANT);
        }
    }

}
