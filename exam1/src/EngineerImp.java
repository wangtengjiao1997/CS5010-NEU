public class EngineerImp implements Engineer{

  private String name;
  private double baseSalary;
  private double bonus;

  public EngineerImp(String name, double baseSalary){
    this.name=name;
    this.baseSalary=baseSalary;
    this.bonus=0;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setBonus(Rating rating) {
    double baseBonus = this.baseSalary;
    baseBonus += pullDepartmentProfit();
    baseBonus += pullNASDQIndex();
    baseBonus += pullManagerMood();
    baseBonus += pullCPI();
    this.bonus=baseBonus;
  }

  @Override
  public double getBonus() {
    return this.bonus;
  }

  @Override
  public int compareTo(Engineer o) {
    return this.name.compareTo(o.getName());
  }
}
