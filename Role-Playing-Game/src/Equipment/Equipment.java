package Equipment;

/**
 * This interface is design for the equipment
 */
public interface Equipment {

  // This function is get the type of the equipment
  GearType getGearType();

  // This function is get the value of the attack
  int getAttack();

  // This function is get the value of the defense
  int getDefense();

  // This function is get the noun description
  String getNoun();

  // This function is get the adjective description
  String getAdjective();

  // This function is get the over all description
  String getName();

  // This function is used to combine the equipments when the slot is full
  Equipment combineEquip(Equipment other);

  String toString();
}
