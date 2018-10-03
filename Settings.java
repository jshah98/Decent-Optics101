
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/*
 * This is the settings screen.The user can change the game settings in this screen.
 * @author Jinansh, Chirstian.
 * @version 1.0.
 * @since 5/06/14.
 * 
 * @param background Used to store the background image.
 */ 
public class Settings extends JPanel //implements ActionListener
{
  
  Image background;
  /*
   * Creates the Settings panel.
   * 
   * @throws IOException e if it cannot successfully store the background image.
   * 
   */ 
    public Settings ()
  {
    try
    {
      background= ImageIO.read (getClass().getResource ("SettingsScreen.png"));
    }
    catch (IOException e) { return; }
    settings ();
  }
    
    
    /**
     * This method draws the backgroumd image.
     * @param g reference variable of Graphics class. 
     */
       protected void paintComponent(Graphics g) 
  {
    super.paintComponent(g); 
    g.drawImage(background,0,0,null);
  }
       
       
       
       /**
        * This method is used to create the Settings menu and adds appropriate buttons and labels to the screen.
        * The action performed methods are used to perform various actions depending on the button clicked. 
        * The if statements are used to determine which icon to display.
        * @param backIcon stores the icon of the back button. 
        * @param backButton stores the back button. 
        * @param offIcon1 stores an image displaying "OFF".
        * @param offIcon2 stores an image displaying "OFF".
        * @param onIcon1  stores an image displaying "ON".
        * @param onIcon2  stores an image displaying "ON".
        * @param lessons a reference variable of the JToggleButton class which stores a JToggleButton.
        * @param quizzes a reference variable of the JToggleButton class which stores a JToggleButton.
        */
        public void settings ()
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
    
    final  ImageIcon offIcon1= new ImageIcon (getClass().getClassLoader().getResource("SettingsButtonOFF2.png"));
    final ImageIcon onIcon1= new ImageIcon (getClass().getClassLoader().getResource("SettingsButtonON2.png"));
    final JToggleButton lessons = new JToggleButton (offIcon1, true);
    lessons.setActionCommand ("lessons");
    lessons.setBorder (BorderFactory.createLineBorder(new Color (128, 0, 0), 1));
    lessons.addActionListener (new ActionListener ()
                                 {
      public void actionPerformed (ActionEvent e)
      {
        if (e.getActionCommand().equals ("lessons"))
        {
          lessons.setIcon (onIcon1);
    lessons.setActionCommand ("lesson");
        }
        else 
        {
          lessons.setIcon (offIcon1);
    lessons.setActionCommand ("lessons");
        }
      }
    });
    add (lessons);
    lessons.setBounds (650, 292, 92, 50);
     
    final JToggleButton quizzes = new JToggleButton (offIcon1, true);
    quizzes.setActionCommand ("quizzes");
    quizzes.setBorder (BorderFactory.createLineBorder(new Color (128, 0, 0), 1));
    quizzes.addActionListener (new ActionListener ()
                                 {
      public void actionPerformed (ActionEvent e)
      {
        if (e.getActionCommand().equals ("quizzes"))
        {
          quizzes.setIcon (onIcon1);
    quizzes.setActionCommand ("quiz");
        }
        else 
        {
         quizzes.setIcon (offIcon1);
   quizzes.setActionCommand ("quizzes");
        }
      }
    });
    add (quizzes);
    quizzes.setBounds (287, 515, 92, 50);
  }

}