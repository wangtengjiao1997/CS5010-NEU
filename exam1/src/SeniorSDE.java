public class SeniorSDE extends EngineerImp{
  private double numOfReports;
  private String name;
  private double baseSalary;
  private double bonus;

  public SeniorSDE(String name, double baseSalary, double report) {
    super(name, baseSalary);
    this.name = name;
    this.baseSalary=baseSalary;
    this.numOfReports =report;
    this.bonus=0;
  }

  @Override
  public void setBonus(Rating rating) {
    this.bonus = numOfReports / 5.0;
  }
}
