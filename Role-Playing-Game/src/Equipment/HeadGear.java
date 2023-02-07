package Equipment;

/**
 * HeadGear class to define the equipments for head
 */
public class HeadGear extends AbstractEquip {

  public HeadGear(int attack, int defense, String adjective, String noun) {
    super(GearType.HEAD_GEAR, attack, defense, adjective, noun);
  }


  /**
   * Combine function to combine the equipment which have the same type
   * @param equip
   * @return Equipment
   */
  @Override
  public Equipment combineEquip(Equipment equip) {
    if (equip == null) {
      throw new IllegalArgumentException("Equipment can't be null.");
    }

    if (equip.getGearType() != this.getGearType()) {
      throw new IllegalArgumentException("Equipment type are not the same.");
    }


    HeadGear newHeadGear = null;
    if (equip.getGearType() == GearType.HEAD_GEAR) {
      newHeadGear = new HeadGear(equip.getAttack() + this.getAttack(), equip.getDefense() + this.getDefense(), equip.getAdjective() + ", " + this.getAdjective(), equip.getNoun());
    }

    return newHeadGear;
  }
}
