package questions;
public class MultipleChoice implements Question{
  private String question;
  private String answer;
  private int type =2;
  public MultipleChoice(String question, String answer, String option1, String option2, String option3){
    this.question = question;
    this.answer = answer;
  }
  public MultipleChoice(String question, String answer, String option1, String option2, String option3, String option4){
    this.question = question;
    this.answer = answer;
  }
  public MultipleChoice(String question, String answer, String option1, String option2, String option3, String option4, String option5){
    this.question = question;
    this.answer = answer;
  }
  public MultipleChoice(String question, String answer, String option1, String option2, String option3, String option4, String option5, String option6){
    this.question = question;
    this.answer = answer;
  }
  public MultipleChoice(String question, String answer, String option1, String option2, String option3, String option4, String option5, String option6, String option7){
    this.question = question;
    this.answer = answer;
  }
  public MultipleChoice(String question, String answer, String option1, String option2, String option3, String option4, String option5, String option6, String option7, String option8){
    this.question = question;
    this.answer = answer;
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
