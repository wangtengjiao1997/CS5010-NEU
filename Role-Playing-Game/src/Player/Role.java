package Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


import Equipment.*;

/**
 * This class defined for declare a role
 */
public class Role implements Player {
  private int attack;
  private int defense;
  private static int MAXHANDFOOT = 2;
  private static int MAXHEAD = 1;
  private ArrayList<Equipment> handGear;
  private ArrayList<Equipment> footWear;
  private Equipment headGear;
  private GearType HAND = GearType.HAND_GEAR;
  private GearType HEAD = GearType.HEAD_GEAR;
  private GearType FOOT = GearType.FOOT_WEAR;


  /**
   * Constructor
   * @param attack
   * @param defense
   */
  public Role(int attack, int defense) {
    if (this.attack < 0 || this.defense < 0) {
      throw new IllegalArgumentException("Attack and defense value can't be negative.");
    }
    this.attack = attack;
    this.defense = defense;
    this.handGear = new ArrayList<Equipment>();
    this.footWear = new ArrayList<Equipment>();
    this.headGear = null;
  }

  /**
   * For player to choose the equipment.
   * It will choose the highest equipment for player if player has empty slot
   * If player don't have empty slot, it will choose the highest equipment to combine it with
   * the equipment player has currently
   * @param equipmentlist
   */
  @Override
  public void choseEquipment(ArrayList<Equipment> equipmentlist) {
    equipmentlist = sortEquipment(equipmentlist);
    for (Equipment equip : equipmentlist) {
      GearType type = equip.getGearType();
      if (type.equals(GearType.HAND_GEAR) && this.handGear.size() < MAXHANDFOOT) {
        this.handGear.add(equip);
        equipmentlist.remove(equip);
        return;
      } else if (type.equals(GearType.FOOT_WEAR) && this.footWear.size() < MAXHANDFOOT) {
        this.footWear.add(equip);
        equipmentlist.remove(equip);
        return;
      } else if (type.equals(GearType.HEAD_GEAR) && this.headGear == null) {
        this.headGear = equip;
        equipmentlist.remove(equip);
        return;
      }
    }

    Equipment equipment = equipmentlist.get(0);
    GearType type = equipment.getGearType();
    switch (type) {
      case HEAD_GEAR:
        headGear = headGear.combineEquip(equipment);
        equipmentlist.remove(equipment);
        break;
      case HAND_GEAR:
        Equipment newHandGear = handGear.get(1).combineEquip(equipment);
        handGear.remove(1);
        handGear.add(newHandGear);
        equipmentlist.remove(equipment);
        break;
      case FOOT_WEAR:
        Equipment newFootWear = footWear.get(1).combineEquip(equipment);
        footWear.remove(1);
        footWear.add(newFootWear);
        equipmentlist.remove(equipment);
        break;
    }
  }

  /**
   * This function will get player's attack
   * @return int
   */
  @Override
  public int getFinalAttack() {
    int finalAttack = 0;
    for (Equipment equip : handGear) {
      finalAttack += equip.getAttack();
    }
    for (Equipment equip : footWear) {
      finalAttack += equip.getAttack();
    }
    if (this.headGear != null) {
      finalAttack += headGear.getAttack();
    }
    return finalAttack;
  }

  /**
   * This function will get player's defense
   * @return int
   */
  @Override
  public int getFinalDefense() {
    int finalDefense = 0;
    for (Equipment equip : handGear) {
      finalDefense += equip.getDefense();
    }
    for (Equipment equip : footWear) {
      finalDefense += equip.getDefense();
    }
    if (this.headGear != null) {
      finalDefense += headGear.getDefense();
    }
    return finalDefense;
  }

  /**
   * this function will sort the equipment list by attack and defense
   * After sort, the equipment with the highest att and def will be the first
   * one to help for choosing equipment
   * @param equiplist
   * @return
   */
  private ArrayList<Equipment> sortEquipment(ArrayList<Equipment> equiplist) {
    Comparator<Equipment> att = Comparator.comparing(Equipment::getAttack).reversed();
    Comparator<Equipment> def = Comparator.comparing(Equipment::getDefense).reversed();
    equiplist.sort(att.thenComparing(def));
    return equiplist;
  }

  /**
   * this will print the equipment player has and the attack and defense for the player
   * @return
   */
  @Override
  public String toString() {
    String Handlist = "";
    String Footlist = "";
    for (Equipment e : this.handGear) {
      Handlist += e.toString() + "   ";
    }
    for (Equipment e : this.footWear) {
      Footlist += e.toString() + "   ";
    }
    return "Hand equipments: " + Handlist + "\n " +
            "Foot equipments: " + Footlist + "\n " +
            "Head equipment: " + this.headGear + "\n " +
            "Final attack:" + this.getFinalAttack() + ", " +
            "Final defense:" + this.getFinalDefense();
  }

}


