import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * This is the main panel for the program.
 * @version 1.0.
 * @author Jinansh, Christian.
 * @since 23/05/14.
 * 
 * @param title panel which has the title component.
 * @param panel panel where user interaction occurs.
 */
public class Optics101 extends JPanel
{
  //JPanel panel = new JPanel ();
  //JPanel title = new JPanel ();
  
  /**
   * The constructor adds the two panels (title and user interaction panel) to the main panel.
   */
  public Optics101 ()
  {
    //title.setPreferredSize (new Dimension (1000, 200));
    //title ();
    //add (title);
    //add (panel);
    mainMenu ();
  }
  
  /**
   * This method removes everything from the screen and adds the title to the title panel.
   * @param f stores the font of the title.
   */
  public void title ()
  {
    this.removeAll ();
    Font f = new Font ("Serif", Font.BOLD, 36);
    JLabel titleLabel = new JLabel ("Optics 101");
    titleLabel.setFont (f);
    add (titleLabel);
    this.revalidate ();
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
   // ImageIcon mainMenuBackground= new ImageIcon (getClass().getClassLoader().getResource("mainMenu.jpg"));
   // JLabel background = new JLabel (mainMenuBackground);
   // add (background);
    ImageIcon highScoresImage = new ImageIcon (getClass().getClassLoader().getResource("highScores.jpg"));
    ImageIcon settingsImage = new ImageIcon (getClass().getClassLoader().getResource("settings.jpg"));
    ImageIcon resumeImage = new ImageIcon (getClass().getClassLoader().getResource("resume.jpg"));
    ImageIcon quizzesImage = new ImageIcon (getClass().getClassLoader().getResource("quizzes.jpg"));
    ImageIcon newImage = new ImageIcon (getClass().getClassLoader().getResource("new.jpg"));
    ImageIcon instructionsImage = new ImageIcon (getClass().getClassLoader().getResource("instructions.jpg"));
    ImageIcon quitImage = new ImageIcon (getClass().getClassLoader().getResource("quit.jpg"));
    final JButton HIGH_SCORES_BUTTON = new JButton(highScoresImage);
    setLayout (null);
    add (HIGH_SCORES_BUTTON);
    HIGH_SCORES_BUTTON.setBounds(0,0, 188, 56);
    final JButton CONTINUE_BUTTON= new JButton (resumeImage);
    add (CONTINUE_BUTTON);
    CONTINUE_BUTTON.setBounds (0, 60, 188, 56);
    final JButton NEW_GAME_BUTTON = new JButton (newImage);
    add (NEW_GAME_BUTTON);
    NEW_GAME_BUTTON .setBounds (0, 120, 188, 56);
    final JButton INSTRUCTIONS_BUTTON = new JButton (instructionsImage);
    add (INSTRUCTIONS_BUTTON);
    INSTRUCTIONS_BUTTON.setBounds (0, 180, 188, 56);
    final JButton SETTINGS_BUTTON= new JButton (settingsImage);
    add (SETTINGS_BUTTON);
    SETTINGS_BUTTON.setBounds (0, 240, 188, 56);
    final JButton QUIZ_BUTTON = new JButton (quizzesImage);
    add (QUIZ_BUTTON);
    QUIZ_BUTTON.setBounds (0, 300, 188, 56);
    final JButton EXIT_BUTTON = new JButton (quitImage);
    add (EXIT_BUTTON);
    EXIT_BUTTON.setBounds (0, 360, 188, 56);
//    CONTINUE_BUTTON.setEnabled (false);
//    panel.setLayout (LAYOUT);
//    LAYOUT.linkSize (CONTINUE_BUTTON,NEW_GAME_BUTTON ,INSTRUCTIONS_BUTTON,SETTINGS_BUTTON, HIGH_SCORES_BUTTON,QUIZ_BUTTON,EXIT_BUTTON);
//    LAYOUT.setAutoCreateGaps (true);
//      LAYOUT.setHorizontalGroup(
//                              LAYOUT.createSequentialGroup()
//                                .addGroup (LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                             .addComponent (CONTINUE_BUTTON)
//                                             .addComponent (NEW_GAME_BUTTON)
//                                             .addComponent (INSTRUCTIONS_BUTTON)
//                                             .addComponent (SETTINGS_BUTTON)
//                                             .addComponent (HIGH_SCORES_BUTTON)
//                                             .addComponent (QUIZ_BUTTON)
//                                             .addComponent (EXIT_BUTTON))
//                               );
//    LAYOUT.setVerticalGroup(
//                            LAYOUT.createSequentialGroup()
//                              .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                          .addComponent(CONTINUE_BUTTON))
//                              .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                          .addComponent(NEW_GAME_BUTTON))
//                              .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                          .addComponent(INSTRUCTIONS_BUTTON))
//                              .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                          .addComponent(SETTINGS_BUTTON))
//                              .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                          .addComponent(HIGH_SCORES_BUTTON))
//                              .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                          .addComponent(QUIZ_BUTTON))
//                              .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                          .addComponent(EXIT_BUTTON))
//                           );
    revalidate ();
  }
  

  
}