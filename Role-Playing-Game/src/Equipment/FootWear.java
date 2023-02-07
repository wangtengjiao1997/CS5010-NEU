package Equipment;

/**
 * FootWear class to define the equipments that foot will wear
 */
public class FootWear extends AbstractEquip {

  // Constructor
  public FootWear(int attack, int defense, String adjective, String noun) {
    super(GearType.FOOT_WEAR, attack, defense, adjective, noun);
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

    FootWear newFootWear = null;
    if (equip.getGearType() == GearType.FOOT_WEAR) {
      newFootWear = new FootWear(equip.getAttack() + this.getAttack(), equip.getDefense() + this.getDefense(), equip.getAdjective() +", "+ this.getAdjective(), equip.getNoun());
    }

    return newFootWear;
  }

}
