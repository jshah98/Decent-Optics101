import java.awt.*;
import javax.swing.*;
/**
 * This class creates an animation which introduces Optics101.
 * @version 1.0.
 * @author Jinansh, Chirstian.
 * @since 15/05/14.
 */

public class SplashScreen extends JPanel
{
  /**
   * The consructor creates a new JPanel and calls the intro ().
   */
  public SplashScreen ()
  {
    super ();
    intro ();
  }
  
  /**
   * This method sets the backgroud color to black.
   */
  public void intro ()
  {
    Graphics a = new Graphics ();
    setBackground (Color.BLACK);
    a.setColor (Color.WHITE);
    a.drawRect (50, 50, 50, 50);
  }
} 