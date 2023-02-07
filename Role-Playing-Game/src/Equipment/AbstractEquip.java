package Equipment;

/**
 * This is an abstract class that will implement the Equipment interface
 */
public abstract class AbstractEquip implements Equipment {

  // Declare the variables
  private GearType type;
  private int attack;
  private int defense;
  private String adjective;
  private String noun;

  /**
   * Constructor
    */

  public AbstractEquip(GearType type, int attack, int defense, String adjective, String noun) {
    this.type = type;
    this.attack = attack;
    this.defense = defense;
    this.adjective = adjective;
    this.noun = noun;

    /**
     * Will throw an exception if the given input is invalid
      */

    if (this.attack < 0 || this.defense < 0) {
      throw new IllegalArgumentException("Attack and defense value can't be negative.");
    }

    // Adjective can't be empty
    if (this.adjective == null || this.adjective.equals("")) {
      throw new IllegalArgumentException("Adjective can't be empty.");
    }

    // Noun can't be negative
    if (this.noun == null || this.noun.equals("")) {
      throw new IllegalArgumentException("Noun can't be empty.");
    }
  }

  /**
   * Get the type of the equipment
   * @return GearType
   */
  @Override
  public GearType getGearType() {
    return this.type;
  }

  /**
   * Get the value of attack
   * @return int
   */
  @Override
  public int getAttack() {
    return this.attack;
  }

  /**
   * Get the value of defense
   * @return int
   */
  @Override
  public int getDefense() {
    return this.defense;
  }

  /**
   * Get the name of the equipment
   * @return String
   */
  @Override
  public String getName() {
    return this.getAdjective() + " " + this.getNoun();
  }

  /**
   * Get the noun of the equipment
   * @return String
   */
  @Override
  public String getNoun() {
    return this.noun;
  }

  /**
   * Get the adjective of the equipment
   * @return String
   */
  @Override
  public String getAdjective() {
    return this.adjective;
  }

  /**
   * toString function which will return the name of the equipment
   * @return String
   */
  @Override
  public String toString(){
    return this.getName();
  }
}
