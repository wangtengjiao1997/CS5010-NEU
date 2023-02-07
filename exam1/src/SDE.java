public class SDE extends EngineerImp{
  private double linesOfCode ;
  private String name;
  private double baseSalary;
  private double bonus;
  private double docs;
  public SDE(String name, double baseSalary, double line, double docs) {
    super(name, baseSalary);
    this.name = name;
    this.baseSalary=baseSalary;
    this.linesOfCode =line;
    this.docs=docs;
    this.bonus=0;
  }

  @Override
  public void setBonus(Rating rating) {
    this.bonus = (linesOfCode / 80.0) + (docs / 5.0);
    switch (rating){
      case SUPERB:
        this.bonus = this.bonus * 1.7;
        break;
      case MEET_EXPECTATION:
        break;
      case EXCEED_EXPECTATION:
        this.bonus = this.bonus * 1.2;
        break;
    }

  }
}
