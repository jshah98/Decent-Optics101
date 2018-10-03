import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;

import java.util.*;

/**
 * This class is used to create store components of a question into one.
 * 
 * @version 1.0.
 * @author Jinansh, Chirstian.
 * @since 15/05/14.
 * 
 * @param option1 String that stores one of the mutiple choice options (that is not the answer).
 * @param option2 String that stores one of the mutiple choice options (that is not the answer).
 * @param option3 String that stores one of the mutiple choice options (that is not the answer).
 * @param answer String that stores the multiple choice option that is the answer.
 * @param question String that stores the actual question.
 * @param ops ArrayList that stores all options and is used to mix up the order.
 */
public class Question 
{
  private String option1;
  private String option2;
  private String option3;
  String answer;
  private String question;
  ArrayList <String> ops = new ArrayList <String> (4);
  
  /**
   * The constructor is used to create a new Question which stores a question, and four options (one of them being the answer). 
   * @param ans stores a random int which is the index of answer string (out of the four options).
   * @param q String that stores the question .
   * @param correct String that stores the answer string.
   * @param op1 String that stores one of the mutiple choice options (that is not the answer).
   * @param op2 String that stores one of the mutiple choice options (that is not the answer).
   * @param op3 String that stores one of the mutiple choice options (that is not the answer).\
   * @param long Used to randomize order of optiions.
   */
  public Question (String q, String correct, String op1, String op2, String op3)
  {
    int counter=0;
    question=q;
    answer = correct;
    option1=op1;
    option2=op2;
    option3=op3;
    ops.add(correct);
    ops.add(op1);
    ops.add(op2);
    ops.add(op3);
    long seed=System.nanoTime();
    Collections.shuffle(ops, new Random(seed));
  }
  
  
  /**
   * This returns the question.
   * @return question  
   */
  public String getQuestion ()
  {
    return question;
  }
  
  /**
   * This returns the first of the three options that are not answers.
   * @return option1
   */
  public String getOption1 ()
  {
    return option1;
  }
  /**
   * This returns the second of the three options that are not answers.
   * @return option2
   */
  public String getOption2 ()
  {
    return option2;
  }
  /**
   * This returns the last of the three options that are not answers.
   * @return option3
   */
  public String getOption3 ()
  {
    return option3;
  }
  /**
   * This returns the answer.
   * @return answer
   */
  public String getAnswer ()
  {
    return answer;
  }  
}