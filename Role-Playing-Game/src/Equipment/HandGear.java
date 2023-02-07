package Equipment;

/**
 * HandGear class to define the equipments for hand
 */
public class HandGear extends AbstractEquip {

  public HandGear(int attack, int defense, String adjective, String noun) {
    super(GearType.HAND_GEAR, attack, defense, adjective, noun);
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

    HandGear newHandGear = null;
    if (equip.getGearType() == GearType.HAND_GEAR) {
      newHandGear = new HandGear(equip.getAttack() + this.getAttack(), equip.getDefense() + this.getDefense(), equip.getAdjective() +", "+ this.getAdjective(), equip.getNoun());
    }

    return newHandGear;
  }
}
