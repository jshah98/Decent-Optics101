import javax.swing.*;
import java.awt.*;
/**
 * This class puts all the components of the game together.
 * @version 2.0.
 * @author Jinansh, Christian.
 * @since 15/05/14.
 * 
 */
public class Optics101App extends JFrame
{
  
  /**
   * This constructor creates a JFrame and adds a SplashScreen to it.
   * It then creates a new window that is 1000 by 800 (pixels).
   */
  public Optics101App ()
  {
    super ();
    //add (new Intro ());
   // this.removeAll();
    //add (new Optics101 ());
    add (new MainMenu ());
    //add (new Game ());
    setSize (965, 700);
    setVisible (true);
    setResizable (false);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
  }
  
  

}