package ca.bcit.comp2526.a2b;

import java.util.ArrayList;

/**
 * SpawnType for each possible tile type in the world.
 * Each Tile type has a number of tickets in the pool.
 * @author Deric
 *
 */
public enum SpawnType {
    PLANT(3), HERBIVORE(1), CARNIVORE(0), NULL(6);

    private static final int poolSize = 10;
    private static ArrayList<SpawnType> spawnPool = new ArrayList<SpawnType>();
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
    private static void init() {
        for (SpawnType st:values()) {
            for (int i = 0;i < st.tickets;i++) {
                spawnPool.add(st);
            }
        }
    }
    
    /**
     * Returns a random spawn type.
     * @return the SpawnType to be returned.
     */
    public static SpawnType spawn() {
        if (spawnPool.size() != poolSize) {
            init();
        }
        int rand = RandomGenerator.nextNumber(poolSize - 1);
        return spawnPool.get(rand);
    }

}
