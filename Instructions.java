import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/*
 * This is the Instructions screen. 
 * @version 1.0.
 * @author Jinansh, Chirstian.
 * @since 5/06/14.
 * 
 * @param background stores the background of this screen.
 */ 
public class Instructions extends JPanel 
{
  Image background;
  /*
   * This method stores the background image to the variable and calls the instructions() method.
   * @throws IOException e when image cannot be successfully stored. 
   * 
   */
  public Instructions()
  {
    try
    {
      background= ImageIO.read (getClass().getResource ("InstructionsBack.jpg"));
    }
    catch (IOException e) { return; }
    instructions ();
  }
  
  
  /**
   * This method adds the buttons to the screen and displays the instructions.
   * The actionPerformed method is used to enable the user to return to the main menu screen. 
   */
  public void instructions ()
  {
    setLayout (null);
    ImageIcon backIcon= new ImageIcon (getClass().getClassLoader().getResource("back.jpg"));
    JButton backButton = new JButton (backIcon);
    backButton.setBorder (BorderFactory.createLineBorder(Color.BLACK, 1));
    backButton.addActionListener (new ActionListener()
      {
        public void actionPerformed (ActionEvent e)
        {
          removeAll ();
          MainMenu.c.add (new MainMenu ());
          revalidate ();
        }
    });
    add (backButton);
    backButton.setBounds (10, 600, 170, 60);
  }
  
  
  /**
   * This method draws the background.
   * @param g reference variable of the Graphics class. 
   */
  protected void paintComponent(Graphics g) 
  {
    super.paintComponent(g); 
    g.drawImage(background,0,0,null);
  }
  
}