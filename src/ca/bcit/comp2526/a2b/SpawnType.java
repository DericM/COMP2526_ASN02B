package ca.bcit.comp2526.a2b;

import java.util.ArrayList;

import ca.bcit.comp2526.a2b.tiles.Carnivore;
import ca.bcit.comp2526.a2b.tiles.Herbivore;
import ca.bcit.comp2526.a2b.tiles.Living;
import ca.bcit.comp2526.a2b.tiles.Omnivore;
import ca.bcit.comp2526.a2b.tiles.Plant;

/**
 * SpawnType for each possible tile type in the world.
 * Each Tile type has a number of tickets in the pool.
 * @author Deric
 *
 */
public enum SpawnType {
    PLANT(30), HERBIVORE(10), CARNIVORE(5), OMNIVORE(2), NULL(53);

    private static final int poolSize = 100;
    private static ArrayList<SpawnType> spawnPool = new ArrayList<SpawnType>();
    private static ArrayList<Living> living;
    
    private int tickets;
    

    /**
     * Constructor.
     * @param tickets for each SpawnType.
     */
    SpawnType(int tickets) {
        this.tickets = tickets;
    }
    
    
    
    /*
     * Adds the SpawnTypes to the SpawnPool.
     */
    public static void init(ArrayList<Living> liv) {
        living = liv;
        for (SpawnType st:values()) {
            for (int i = 0;i < st.tickets;i++) {
                spawnPool.add(st);
            }
        }
    }
    

    public static void spawnRand(Cell cell) {
        spawn(cell, spawnPool.get(drawTicket()));
    }
    
    
    public static void spawnSingle(Cell cell, SpawnType type) {
        SpawnType stype = spawnPool.get(drawTicket());
        if(stype == type) {
            spawn(cell, stype);
        }
    }

    
    public static int drawTicket() {
        int rand = RandomGenerator.nextNumber(poolSize - 1);
        return rand;
    }
    
    
    
    
    /*
     * Spawns a Random tile. See SpawnType for spawn rates.
     * 
     * @param c the cell in which to spawn the tile.
     */
    public static void spawn(Cell cell, SpawnType type) {
        Living newLife;
        switch (type) {
          case PLANT:
              newLife = new Plant(cell);
              break;
          case HERBIVORE:
              newLife = new Herbivore(cell);
              break;
          case CARNIVORE:
              newLife = new Carnivore(cell);
              break;
          case OMNIVORE:
              newLife = new Omnivore(cell);
              break;
          default:
              return;
        }
        living.add(newLife);
    }

}
