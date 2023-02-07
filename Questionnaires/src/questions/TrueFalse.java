package questions;
public class TrueFalse implements Question{
  private String question;
  private String answer;
  private int type;
  public TrueFalse(String question, String answer){
    this.question = question;
    this.answer = answer;
    this.type = 1;
  }
  @Override
  public String getText() {
    return question;
  }

  @Override
  public String answer(String answer) {
    if(answer.equals(this.answer)){
      return "Correct";
    }else{
      return "Incorrect";
    }
  }

  @Override
  public int questiontype() {
    return type;
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
