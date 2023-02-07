import java.util.ArrayList;
import java.util.Iterator;

public class DepartmentImp implements Department{
  private OrderedList<Engineer> team1;
  private OrderedList<Engineer> team2;
  private OrderedList<Engineer> team3;
  private OrderedList<Engineer> team4;


  @Override
  public boolean hire(Engineer e, int teamId) {
    if (teamId == 0){
      if (team1.size()>=3){
        return false;
      }
      team1.add(e);
      return true;
    } else if (teamId == 1) {
      if (team1.size()>=3){
        return false;
      }
      team2.add(e);
      return true;
    } else if (teamId == 2) {
      if (team1.size()>=3){
        return false;
      }
      team3.add(e);
      return true;
    } else if (teamId == 3) {
      if (team1.size()>=3){
        return false;
      }
      team4.add(e);
      return true;
    }else{
      throw new ArrayIndexOutOfBoundsException("Wrong team id");
    }
  }

  @Override
  public void giveOutBonus() {
    Iterator<Engineer> it = this.iterator();
    while(it.hasNext()) {
      Engineer e = it.next();
      e.setBonus(Rating.EXCEED_EXPECTATION);
    }
  }

  @Override
  public void layoff(double bonusThreshold) {
    team1.subList(engineer -> {engineer.getBonus()<bonusThreshold});
  }


  @Override
  public Iterator<Engineer> iterator() {
    return new EngineerIterator<>(team1,team2,team3,team4);
  }
}
