public class JuniorSDE extends EngineerImp{
  private double linesOfCode ;
  private String name;
  private double baseSalary;
  private double bonus;
  public JuniorSDE(String name, double baseSalary, double line) {
    super(name, baseSalary);
    this.name = name;
    this.baseSalary=baseSalary;
    this.linesOfCode =line;
    this.bonus=0;
  }

  @Override
  public void setBonus(Rating rating) {
    this.bonus = linesOfCode / 100.0;

    switch (rating){
      case SUPERB:
        this.bonus = this.bonus * 2;
        break;
      case MEET_EXPECTATION:
        break;
      case EXCEED_EXPECTATION:
        break;
    }

  }
}
