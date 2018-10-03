import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
/**
 * This is the main panel for the program.
 * @version 2.0.
 * @author Jinansh, Christian.
 * @since 5/06/14.
 * 
 * @param background stores the background image.
 * @param Optics101App reference variable of the Optics101App class. 
 */
public class MainMenu extends JPanel implements ActionListener
{
  static Optics101App c;
  Image background;
  
  /**
   * This stores the background Image in variable image and then calls the mainMenu () method.
   * @throws IOException 
   */
  public MainMenu ()
  {
    try
    {
      background= ImageIO.read (getClass().getResource ("mainMenu.jpg"));
    }
    catch (IOException e) { return; }
    mainMenu ();
  }
  
  /**
   * This method draws the background.
   * @param g used to access variables in Graphics class.
   */
  protected void paintComponent(Graphics g) 
  {
    super.paintComponent(g); 
    g.drawImage(background,0,0,null);
  }
    /**
   * The method creates the main menu options and adds them to the user interactions panel.
   * @param LAYOUT sets layout of user interactions panel to be GroupLayout.
   * @param CONTINUE_BUTTON stores a JButton titled "Continue".
   * @param NEW_GAME_BUTTON stores a JButton titled "New Game".
   * @param INSTRUCTIONS_BUTTON stores a JButton titled "Instructions".
   * @param SETTINGS_BUTTON stores a JButton titled "Settings".
   * @param HIGH_SCORES_BUTTON stores a JButton titled "High Scores".
   * @param QUIZ_BUTTON stores a JButton titled "Quiz".
   * @param EXIT_BUTTON stores a JButton titled "Exit".
   */
  public void mainMenu ()
  {
    ImageIcon highScoresImage = new ImageIcon (getClass().getClassLoader().getResource("highScores.jpg"));
    ImageIcon settingsImage = new ImageIcon (getClass().getClassLoader().getResource("settings.jpg"));
    ImageIcon resumeImage = new ImageIcon (getClass().getClassLoader().getResource("resume.jpg"));
    ImageIcon quizzesImage = new ImageIcon (getClass().getClassLoader().getResource("quizzes.jpg"));
    ImageIcon newImage = new ImageIcon (getClass().getClassLoader().getResource("new.jpg"));
    ImageIcon instructionsImage = new ImageIcon (getClass().getClassLoader().getResource("instructions.jpg"));
    ImageIcon quitImage = new ImageIcon (getClass().getClassLoader().getResource("quit.jpg"));
    final JButton HIGH_SCORES_BUTTON = new JButton(highScoresImage);
    setLayout (null);
    HIGH_SCORES_BUTTON.addActionListener (this);
    HIGH_SCORES_BUTTON.setBorder (BorderFactory.createLineBorder(Color.BLACK, 1));
    add (HIGH_SCORES_BUTTON);
    HIGH_SCORES_BUTTON.setBounds(540,400, 188, 56);
//    final JButton CONTINUE_BUTTON= new JButton (resumeImage);
//    CONTINUE_BUTTON.addActionListener (this);
//    add (CONTINUE_BUTTON);
//    CONTINUE_BUTTON.setBounds (0, 60, 188, 56);
    final JButton NEW_GAME_BUTTON = new JButton (newImage);
    NEW_GAME_BUTTON.addActionListener (new ActionListener()
      {
        public void actionPerformed (ActionEvent e)
        {
          removeAll ();
          c.add (new Game ());
          revalidate ();
        }
      });
    NEW_GAME_BUTTON.setBorder (BorderFactory.createLineBorder(Color.BLACK, 1));
    add (NEW_GAME_BUTTON);
    NEW_GAME_BUTTON .setBounds (660, 280, 188, 56);
    final JButton INSTRUCTIONS_BUTTON = new JButton (instructionsImage);
    INSTRUCTIONS_BUTTON.addActionListener (new ActionListener()
      {
        public void actionPerformed (ActionEvent e)
        {
          removeAll ();
          c.add (new Instructions ());
          revalidate ();
        }
      });
    INSTRUCTIONS_BUTTON.setBorder (BorderFactory.createLineBorder(Color.BLACK, 1));
    add (INSTRUCTIONS_BUTTON);
    INSTRUCTIONS_BUTTON.setBounds (590, 340, 188, 56);
    final JButton SETTINGS_BUTTON= new JButton (settingsImage);
    SETTINGS_BUTTON.addActionListener (new ActionListener()
      {
        public void actionPerformed (ActionEvent e)
        {
          removeAll ();
          c.add (new Settings ());
          revalidate ();
        }
      });
    SETTINGS_BUTTON.setBorder (BorderFactory.createLineBorder(Color.BLACK, 1));
    add (SETTINGS_BUTTON);
    SETTINGS_BUTTON.setBounds (510, 460, 188, 56);
    final JButton QUIZ_BUTTON = new JButton (quizzesImage);
    QUIZ_BUTTON.addActionListener (this);
    QUIZ_BUTTON .setBorder (BorderFactory.createLineBorder(Color.BLACK, 1));
    add (QUIZ_BUTTON);
    QUIZ_BUTTON.setBounds (486, 522, 188, 56);
    final JButton EXIT_BUTTON = new JButton (quitImage);
    EXIT_BUTTON.setBorder (BorderFactory.createLineBorder(Color.BLACK, 1));
    EXIT_BUTTON.addActionListener (new ActionListener()
      {
        public void actionPerformed (ActionEvent e)
        {
          c.dispose ();
        }
      });
    add (EXIT_BUTTON);
    EXIT_BUTTON.setBounds (470, 584, 188, 56);
  }
  /**
   * The actionPerformed methods are used to call various methods depending on the action. 
   * @param e reference to the ActionEvent class.
   */
  public void actionPerformed (ActionEvent e)
  {
  }
  
  /**
   * The main method creates an object of the Optics101App class.
   */
  public static void main (String [] args)
  {
   c = new Optics101App ();    
  }
}