package questions;
public interface Question extends Comparable<Question> {
  public String getText();
  public String answer(String answer);
  public int questiontype();
}
