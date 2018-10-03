import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;


public class Quiz extends JPanel implements MouseListener
{
  Image background;
  JLabel title;
  JLabel option1;
  JLabel option2;
  JLabel option3;
  JLabel option4;
  int questionNum=0;
  int correct=0;
  ArrayList<Question> questions= new ArrayList<Question>(); 
  Quiz()
  {
    addMouseListener(this);
    setLayout (null);
    try
    {
      background= ImageIO.read (getClass().getResource ("QuizScreen2.png"));
    }
    catch (IOException e) { return; }
    try
    {
      BufferedReader input = new BufferedReader(new FileReader("Questions.txt"));
      for (int x = 0; x < 6; x++)
      {
        String one = input.readLine();
        String two = input.readLine();
        String three = input.readLine();
        String four = input.readLine();
        String five= input.readLine();
        questions.add(new Question (one,two,three,four,five));  
      }
    }
    catch(Exception e)
    {
      JOptionPane.showMessageDialog(null,"Questions file could not be found");
    }
    draw();
  }
  public void draw()
  {
    setLayout (null);
    title= new JLabel(questions.get(questionNum).getQuestion());
    option1= new JLabel(questions.get(questionNum).ops.get(0));
    option2= new JLabel(questions.get(questionNum).ops.get(1));
    option3= new JLabel(questions.get(questionNum).ops.get(2));
    option4= new JLabel(questions.get(questionNum).ops.get(3));
    title.setOpaque(false);
    option1.setOpaque(false);
    option2.setOpaque(false);
    option3.setOpaque(false);
    option4.setOpaque(false);
    title.setForeground(Color.WHITE);
    option1.setForeground(Color.WHITE);
    option2.setForeground(Color.WHITE);
    option3.setForeground(Color.WHITE);
    option4.setForeground(Color.WHITE);
    add(title);
    add(option1);
    add(option2);
    add(option3);
    add(option4);
    title.setBounds(70,150,400,160);
    option1.setBounds(130,375,295,40);
    option2.setBounds(150,445,295,40);
    option3.setBounds(180,520,295,40);
    option4.setBounds(200,595,295,40);
    labelFit(title);
    labelFit(option1);
    labelFit(option2);
    labelFit(option3);
    labelFit(option4);
  }
  public void labelFit(JLabel label)
  {
    Font labelFont = label.getFont();
    String labelText = label.getText();
    int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
    int componentWidth = label.getWidth();
    double widthRatio = (double)componentWidth / (double)stringWidth;
    int newFontSize = (int)(labelFont.getSize() * widthRatio);
    int componentHeight = label.getHeight();
    int fontSizeToUse = Math.min(newFontSize, componentHeight);
    label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
  }
  
  protected void paintComponent(Graphics g) 
  {
    super.paintComponent(g); 
    g.drawImage(background,0,0,null);
  }
  
  public void mouseClicked(MouseEvent e) 
  {
    if((e.getX()>120 && e.getX()<430&&e.getY()>364&&e.getY()<416)||(e.getX()>145 && e.getX()<457&&e.getY()>440&&e.getY()<490)||(e.getX()>170 && e.getX()<480&&e.getY()>515&&e.getY()<565)||(e.getX()>195 && e.getX()<505&&e.getY()>590&&e.getY()<640))
    {
      if(e.getX()>120 && e.getX()<430&&e.getY()>364&&e.getY()<416)
      {
        if(questions.get(questionNum).ops.get(0).equals(questions.get(questionNum).getAnswer()))
          correct++;
      }
      else if(e.getX()>145 && e.getX()<457&&e.getY()>440&&e.getY()<490)
      {
        if(questions.get(questionNum).ops.get(1).equals(questions.get(questionNum).getAnswer()))
          correct++;
      }
      else if(e.getX()>170 && e.getX()<480&&e.getY()>515&&e.getY()<565)
      {
        if(questions.get(questionNum).ops.get(2).equals(questions.get(questionNum).getAnswer()))
          correct++;
      }
      else 
      {
        if(e.getX()>195 && e.getX()<505&&e.getY()>590&&e.getY()<640)
        {
          if(questions.get(questionNum).ops.get(3).equals(questions.get(questionNum).getAnswer()))
            correct++;
        }
      }
      questionNum++;
      if(questionNum==6)
      {
        JOptionPane.showMessageDialog(null,"Congratulations! You answered "+correct+"/5 questions correctly! ");
        questionNum=0;
        correct=0;
        removeAll ();
        MainMenu.c.add (new MainMenu ());
        revalidate ();
      }
      else
      {
        remove(title);
        remove(option1);
        remove(option2);
        remove(option3);
        remove(option4);
        draw();
        updateUI();
      }
    }
  } 
  public void mouseDragged (MouseEvent e) 
  {
  }
  public void mousePressed(MouseEvent e) 
  {
  }
  
  public void mouseReleased(MouseEvent e) 
  {
  }
  
  public void mouseEntered(MouseEvent e) 
  {
  }
  
  public void mouseExited(MouseEvent e) 
  {
  }
}