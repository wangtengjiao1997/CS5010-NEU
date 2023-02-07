import org.junit.Test;


import dungeon.Level;
import dungeon.MedievalLevelBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class test {
  private static final int FIRST_ROOM = 0;

  /** Test adding rooms. */
  @Test
  public void testAddingRoomsTarget() {
    MedievalLevelBuilder b = new MedievalLevelBuilder(1, 3, 0, 0);
    b.addRoom("Entrance");
    b.addRoom("Hallway");
    b.addRoom("Cave");
    Level l1 = b.build();
    String expected = "Level 1 contains 3 rooms:\n\n"
            + "Room 0 -- Entrance\nMonsters:\n\tNone\nTreasures:\n\tNone\n\n"
            + "Room 1 -- Hallway\nMonsters:\n\tNone\nTreasures:\n\tNone\n\n"
            + "Room 2 -- Cave\nMonsters:\n\tNone\nTreasures:\n\tNone\n";
    assertEquals("Error adding rooms", expected, l1.toString());
  }

  /** Testing adding too many treasures. */
  @Test(expected = IllegalStateException.class)

  public void testAddingTooManyTreasures() {
    MedievalLevelBuilder b = new MedievalLevelBuilder(1, 0, 0, 0);
    b.addRoom("Entrance");
    try {
      b.addPotion(FIRST_ROOM);
      fail("Expected error adding too many potions");
    } catch (IllegalStateException ex) {
      // this is what we expect
    }
    try {
      b.addGold(FIRST_ROOM, 10);
      fail("Expected error adding too many gold");
    } catch (IllegalStateException ex) {
      // this is what we expect
    }
    try {
      b.addWeapon(FIRST_ROOM, "sword");
      fail("Expected error adding too many weapons");
    } catch (IllegalStateException ex) {
      // this is what we expect
    }
    try {
      b.addSpecial(FIRST_ROOM, "magic sword", 100);
      fail("Expected error adding too many special treasures");
    } catch (IllegalStateException ex) {
      // this is what we expect
    }
  }

  /** Test adding treasures. */
  @Test(timeout = 3000)
  public void testAddingTreasureTarget() {
    MedievalLevelBuilder b = new MedievalLevelBuilder(1, 1, 0, 4);
    b.addRoom("Dungeon");
    b.addPotion(FIRST_ROOM);
    b.addGold(FIRST_ROOM, 10);
    b.addWeapon(FIRST_ROOM, "sword");
    b.addSpecial(FIRST_ROOM, "magic sword", 100);
    Level l1 = b.build();
    String expected = "Level 1 contains 1 rooms:\n\n"
            + "Room 0 -- Dungeon\nMonsters:\n\tNone\nTreasures:\n"
            + "\ta healing potion (value = 1)\n"
            + "\tpieces of gold (value = 10)\n"
            + "\tsword (value = 10)\n"
            + "\tmagic sword (value = 100)\n";
    assertEquals("Error adding rooms", expected, l1.toString());
  }
}
