package ca.bcit.comp2526.a2b;

import ca.bcit.comp2526.a2b.tiles.Carnivore;
import ca.bcit.comp2526.a2b.tiles.Entity;
import ca.bcit.comp2526.a2b.tiles.Herbivore;
import ca.bcit.comp2526.a2b.tiles.Omnivore;
import ca.bcit.comp2526.a2b.tiles.Plant;
import ca.bcit.comp2526.a2b.tiles.Water;

import java.util.ArrayList;


/**
 * SpawnType for each possible tile type in the world. Each Tile type has a
 * number of tickets in the pool.
 * 
 * @author Deric
 *
 */
public enum SpawnPool {
    PLANT(20), HERBIVORE(20), CARNIVORE(10), OMNIVORE(10), WATER(1), NULL(40);

    private static ArrayList<SpawnPool> spawnPool = new ArrayList<SpawnPool>();
    private static ArrayList<Entity> takesTurn;

    private int tickets;

    /**
     * Constructor.
     * 
     * @param tickets
     *            for each SpawnType.
     */
    SpawnPool(int tickets) {
        this.tickets = tickets;
    }

    /**
     * initialize the spawnPool
     * 
     * @param liv
     *            a list of all the movable entities in the world.
     */
    public static void init(ArrayList<Entity> liv) {
        takesTurn = liv;
        for (SpawnPool st : values()) {
            for (int i = 0; i < st.tickets; i++) {
                spawnPool.add(st);
            }
        }
    }

    /*
     * spawns a random entity.
     */
    public static void spawnRand(Cell cell) {
        spawn(cell, spawnPool.get(drawTicket()));
    }

    /*
     * draws a ticket from the spawnPool.
     */
    private static int drawTicket() {
        int rand = RandomGenerator.nextNumber(spawnPool.size() - 1);
        return rand;
    }

    /**
     * Spawns a Random tile. See SpawnType for spawn rates.
     * 
     * @param cell
     *            the cell in which to spawn the tile.
     * @param type
     *            the type of entity to spawn.
     */
    public static void spawn(Cell cell, SpawnPool type) {
        Entity newLife;
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
          case WATER:
              newLife = new Water(cell);
              break;
          default:
              return;
        }
        takesTurn.add(newLife);
    }

}
