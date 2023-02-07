
import org.junit.Before;
import org.junit.Test;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import Equipment.FootWear;
import Equipment.Equipment;
import Equipment.HandGear;
import Equipment.HeadGear;
import Player.Player;
import Player.Role;
import Battle.Battle;

public class test {
  @Test
  public void testFootWear() {
    FootWear footWear1 = new FootWear(20, 30, "Good", "Cool");
    assertEquals("FOOT_WEAR", footWear1.getGearType().toString());
    assertEquals(20, footWear1.getAttack());
    assertEquals(30, footWear1.getDefense());
    assertEquals("Good", footWear1.getAdjective());
    assertEquals("Cool", footWear1.getNoun());
  }

  @Test
  public void testHeadGear() {
    HeadGear headGear1 = new HeadGear(20, 30, "Good", "Cool");
    assertEquals("HEAD_GEAR", headGear1.getGearType().toString());
    assertEquals(20, headGear1.getAttack());
    assertEquals(30, headGear1.getDefense());
    assertEquals("Good", headGear1.getAdjective());
    assertEquals("Cool", headGear1.getNoun());
  }

  @Test
  public void testHandGear() {
    HandGear handGear1 = new HandGear(20, 30, "Nice", "Wow");
    assertEquals("HAND_GEAR", handGear1.getGearType().toString());
    assertEquals(20, handGear1.getAttack());
    assertEquals(30, handGear1.getDefense());
    assertEquals("Nice", handGear1.getAdjective());
    assertEquals("Wow", handGear1.getNoun());
  }

  @Test
  public void testFootWearCombine() {
    FootWear footWear1 = new FootWear(20, 30, "Nice", "Wow");
    FootWear footWear2 = new FootWear(10, 20, "Nice eee", "Wow www");
    assertEquals(30, footWear1.combineEquip(footWear2).getAttack());
    assertEquals(50, footWear1.combineEquip(footWear2).getDefense());
    assertEquals("Nice eee, Nice", footWear1.combineEquip(footWear2).getAdjective());
    assertEquals("Wow www", footWear1.combineEquip(footWear2).getNoun());
    assertEquals("Nice eee, Nice Wow www", footWear1.combineEquip(footWear2).getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCombineWithDifferentType() {
    FootWear footWear1 = new FootWear(20, 30, "Nice", "Wow");
    HandGear handGear1 = new HandGear(20, 30, "Nice", "Wow");
    HeadGear headGear1 = new HeadGear(20, 30, "Wok", "Ca");
    HandGear handGear2 = null;
    footWear1.combineEquip(handGear1).getAttack();
    footWear1.combineEquip(handGear2).getAttack();
    footWear1.combineEquip(headGear1).getAttack();
    footWear1.combineEquip(handGear1).getGearType();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAttackOrDefenseInputForFootWear() {
    FootWear footWear1 = new FootWear(-20, 30, "Good", "Cool");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAdjOrNounInputForFootWear() {
    FootWear footWear1 = new FootWear(20, 30, null, "");
  }

  @Test
  public void testHandGearCombine() {
    HandGear handGear1 = new HandGear(20, 30, "Nice", "Wow");
    HandGear handGear2 = new HandGear(10, 20, "Nice eee", "Wow www");
    assertEquals(30, handGear1.combineEquip(handGear2).getAttack());
    assertEquals(50, handGear1.combineEquip(handGear2).getDefense());
    assertEquals("Nice eee, Nice", handGear1.combineEquip(handGear2).getAdjective());
    assertEquals("Wow www", handGear1.combineEquip(handGear2).getNoun());
    assertEquals("Nice eee, Nice Wow www", handGear1.combineEquip(handGear2).getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAttackOrDefenseInputForHandGear() {
    HandGear handGear1 = new HandGear(-20, 30, "Good", "Cool");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAdjOrNounInputForHandGear() {
    HandGear handGear1 = new HandGear(20, 30, null, "");
  }

  @Test
  public void testHeadGearCombine() {
    HeadGear headGear1 = new HeadGear(20, 30, "Good", "Cool");
    HeadGear headGear2 = new HeadGear(10, 20, "Good ddd", "Cool lll");
    assertEquals(30, headGear1.combineEquip(headGear2).getAttack());
    assertEquals(50, headGear1.combineEquip(headGear2).getDefense());
    assertEquals("Good ddd, Good", headGear1.combineEquip(headGear2).getAdjective());
    assertEquals("Cool lll", headGear1.combineEquip(headGear2).getNoun());
    assertEquals("Good ddd, Good Cool lll", headGear1.combineEquip(headGear2).getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAttackOrDefenseInputForHeadGear() {
    HeadGear headGear1 = new HeadGear(-20, 30, "Good", "Cool");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAdjOrNounInputForHeadGear() {
    HeadGear headGear1 = new HeadGear(20, 30, null, "");
  }

  @Test
  public void testPlayer() {
    Equipment equipment1 = new FootWear(3, 5, "GOOD1", "feet");
    Equipment equipment2 = new HandGear(1, 2, "GOOD2", "GLOVE2");
    Equipment equipment3 = new HandGear(4, 7, "GOOD3", "GLOVE3");
    Equipment equipment4 = new HandGear(4, 3, "GOOD4", "GLOVE4");
    Equipment equipment5 = new HeadGear(8, 8, "GOOD5", "head1");
    Equipment equipment6 = new HeadGear(10, 3, "GOOD6", "head2");
    Equipment equipment7 = new HeadGear(3, 10, "GOOD7", "head3");
    Equipment equipment8 = new HeadGear(7, 3, "GOOD8", "head4");

    ArrayList<Equipment> list = new ArrayList<Equipment>();
    list.add(equipment1);
    list.add(equipment2);
    list.add(equipment3);
    list.add(equipment4);
    list.add(equipment5);
    list.add(equipment6);
    list.add(equipment7);
    list.add(equipment8);

    Player player1 = new Role(0, 0);
    Player player2 = new Role(0, 0);

    Battle b = new Battle(player1, player2, list);
    /*for (Equipment x : lis) {
      System.out.print(x.getName() + "\n");
    }
    System.out.print("\n\n");*/
    player1.choseEquipment(list);
    player1.choseEquipment(list);
    player1.choseEquipment(list);
    player1.choseEquipment(list);
    player1.choseEquipment(list);
    /*for (Equipment x : lis) {
      System.out.print(x.getName() + "\n");
    }*/
    assertEquals("Hand equipments: GOOD3 GLOVE3   GOOD4 GLOVE4   \n" +
            " Foot equipments: GOOD1 feet   \n" +
            " Head equipment: GOOD5, GOOD6 head1\n" +
            " Final attack:29, Final defense:26", player1.toString());
  }
  @Test
  public void testBattleFightAndLog() {
    Equipment equipment1 = new FootWear(3, 5, "GOOD1", "foot4");
    Equipment equipment2 = new HandGear(1, 20, "GOOD2", "GLOVE2");
    Equipment equipment3 = new HandGear(4, 10, "GOOD3", "GLOVE3");
    Equipment equipment4 = new HandGear(4, 13, "GOOD4", "GLOVE4");
    Equipment equipment5 = new HandGear(8, 8, "GOOD5", "hand1");
    Equipment equipment6 = new HandGear(10, 3, "GOOD6", "hand2");
    Equipment equipment7 = new FootWear(3, 10, "GOOD7", "foot2");
    Equipment equipment8 = new FootWear(7, 7, "GOOD8", "foot3");
    Equipment equipment9 = new HeadGear(3, 7, "GOOD9", "head4");
    Equipment equipment10 = new HeadGear(15, 3, "GOOD10", "head4");
    ArrayList<Equipment> list = new ArrayList<Equipment>();
    list.add(equipment1);
    list.add(equipment2);
    list.add(equipment3);
    list.add(equipment4);
    list.add(equipment5);
    list.add(equipment6);
    list.add(equipment7);
    list.add(equipment8);
    list.add(equipment9);
    list.add(equipment10);
    Player player1 = new Role(0, 0);
    Player player2 = new Role(0, 0);
    Battle battle= new Battle(player1, player2, list);
    System.out.print(battle.fight()+"\n");
    System.out.print(player1.toString()+"\n");
    System.out.print(player2.toString()+"\n");
    System.out.print(battle.getLog()+"\n");
  }
}
