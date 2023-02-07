package questions;
public class Likert implements Question{

  private String question;
  private String answer;
  private int type;
  public Likert(String question){
    this.question = question;
    this.type =4;
  }
  @Override
  public String getText() {
    return this.question;
  }

  @Override
  public String answer (String answer) {
    int answer_num = Integer.parseInt(answer);
    if (answer_num>0 && answer_num<=5) {
      return "Correct";
    }else{
      return "Incorrect";
    }
  }

  @Override
  public int questiontype() {
    return this.type;
  }
  @Override
  public int compareTo(Question question){
    if(this.type < question.questiontype()){
      return -1;
    }else if(this.type == question.questiontype()){
      return this.question.compareTo(question.getText());
    }else{
      return 1;
    }
  }
}
