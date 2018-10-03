import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Intro extends JPanel
{
//  public void splashScreen ()
//  {
//    JFrame test= new JFrame();
//    Intro splash= new Intro();
//    JLabel imageLabel= new JLabel();
//    ImageIcon pic= new ImageIcon("FINAL3.gif");
//    imageLabel.setIcon(pic);
//    splash.add(imageLabel);
//    splash.setLayout(new FlowLayout(0));
//    splash.setSize(585,585);
//    test.add(splash);
//    test.setVisible(true);
//    test.setSize(600,600);
//    test.setBackground(Color.BLACK);
//    try
//    {
//      Thread.sleep(1300);
//    }
//    catch(Exception e){}
//    pic= new ImageIcon("backgroundFinal.jpg");
//    imageLabel.setIcon(pic);  
//    
//  }
//  public Intro()
//  {
//    super();
//    this.setOpaque(true);
//    this.setBackground(Color.BLACK); 
//    splashScreen ();
//  }
  
  
    Image background;
  public Intro()
  {
    try
    {
      background= ImageIO.read (getClass().getResource ("FINAL3.gif"));
    }
    catch (IOException e) { return; }
  }
  
  protected void paintComponent(Graphics g) 
  {
    super.paintComponent(g); 
    g.drawImage(background,0,0,null);
        try
    {
      Thread.sleep(1300);
    }
    catch(Exception e){}
  }
}