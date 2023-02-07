import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import questions.*;
import static org.junit.Assert.*;

public class TestQuestionnaires {

  @Test
  public void testQuestionOrdering() {
    List<Question> questions = new ArrayList<>();
    Question f = new MultipleSelect("Which of these are included in the Bill " + "of Rights?",
            "1 4", "Freedom of speech", "Freedom to not pay taxes",
            "Freedom to travel anywhere in the world",
            "Right against unreasonable searches and seizures");
    questions.add(f);

    Question h = new Likert("Assignment 2 was an easy assignment.");
    questions.add(h);

    Question a = new TrueFalse(
            "Did you test to verify that increasing the speed " + "beyond the limit does not work?",
            "True");
    questions.add(a);

    Question c = new MultipleChoice(
            "Which one of these options accurately describes your experience in Assignment 2?", // text
            "1", // correct // answer
            "I wrote all my tests before my implementation", // option 1
            "I wrote some but not all tests before my implementation",
            // option 2
            "I tested a little, coded a little, and so on", // option 3
            "I wrote most of my implementation before I wrote tests"); // option 4
    questions.add(c);

    Question e = new MultipleSelect("What is one hour equal to? ", "1 3", // correct answer
            "60 minutes", "60 seconds", "3600 seconds", "half a day");
    questions.add(e);

    Question b = new TrueFalse("Did you test for the constructor throwing an "
            + "exception if the speed intervals for gears " + "did not overlap?", "True");
    questions.add(b);

    Question g = new Likert("I think PDP is a waste of time.");
    questions.add(g);

    Question d = new MultipleChoice("How flexible is your design to adding an extra gear?", // text
            "1", // correct option
            "Very flexible: very less or no code changes required", // option 1
            "Somewhat flexible: some code changes required", // option 2
            "Extensive code changes required"); // option 3
    questions.add(d);


    System.out.println("Before: \n" + questions.toString().replace(",", "\n"));

    Collections.sort(questions);

    System.out.println("After: \n" + questions.toString().replace(",", "\n"));

    assertEquals(b.getText(), questions.get(0).getText());
    assertEquals(a.getText(), questions.get(1).getText());
    assertEquals(d.getText(), questions.get(2).getText());
    assertEquals(c.getText(), questions.get(3).getText());
    assertEquals(e.getText(), questions.get(4).getText());
    assertEquals(f.getText(), questions.get(5).getText());
    assertEquals(h.getText(), questions.get(6).getText());
    assertEquals(g.getText(), questions.get(7).getText());
  }
  @Test
  public void testMultipleSelect(){
    List<Question> questions = new ArrayList<>();
    Question a = new MultipleSelect("Which of these are animal?","1 2","Bird","Cow","apple");
    Question b = new MultipleSelect("Which of these are animal?","1 2","Bird","Cow","apple","bee");
    Question c = new MultipleSelect("Which of these are animal?","1 5","Bird","Cow","apple","bee","dog");
    Question d = new MultipleSelect("Which of these are animal?","1 5","Bird","Cow","apple","bee","dog","pear");
    Question e = new MultipleSelect("Which of these are animal?","1 5 2 7","Bird","Cow","apple","bee","dog","pear","Monkey");
    Question f = new MultipleSelect("Which of these are animal?","1 2 7","Bird","Cow","apple","bee","dog","pear","Monkey","pen");
    questions.add(a);
    questions.add(b);
    questions.add(c);
    questions.add(d);
    questions.add(e);
    questions.add(f);
    assertEquals(c.getText(), questions.get(2).getText());
    assertEquals(c.answer("1 5"), "Correct");
    assertEquals(c.answer("1 5 2"), "Incorrect");
  }
  @Test
  public void testMultipleChoice(){
    Question c = new MultipleSelect("Which of these are animal?","1","pen","wine","apple","bee","dog");
    assertEquals(c.getText(), "Which of these are animal?");
    assertEquals(c.answer("1"), "Correct");
    assertEquals(c.answer("2"), "Incorrect");
  }
  @Test
  public void testLikert(){
    Question c = new Likert("Do you like dog?");
    assertEquals(c.getText(), "Do you like dog?");
    assertEquals(c.answer("3"), "Correct");
    assertEquals(c.answer("7"), "Incorrect");
  }
  @Test
  public void testTrueFalse(){
    Question c = new TrueFalse("Are you a dog?","False");
    assertEquals(c.getText(), "Are you a dog?");
    assertEquals(c.answer("False"), "Correct");
    assertEquals(c.answer("True"), "Incorrect");
  }
}
