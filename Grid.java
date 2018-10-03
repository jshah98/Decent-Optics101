import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
/**
 * The grid on which the game will be played.
 * @version 2.0.
 * @author Jinansh, Christian.
 * @since 5/06/14.
 * 
 * @param size stores the number of rows and columns in the grid.
 */
public class Grid extends JPanel
{
  private int size;
  
  /**
   * This stores the number of rows and columns.
   * @param rows stores the number of rows.
   * @param cols stores the number of columns.
   */
  public Grid (int size)
  {
    this.size = size;
  }
  
  public void removeAllGameObjects ()
  {
    
  }
  
  /**
   * This method draws the grid onto the game screen.
   * @param g reference variable of the Graphics class. 
   */
  public void paint (Graphics g)
  {
    int x = 964/2- (size*50/2);
    g.setColor (Color.WHITE);
    for (int c = 0;  c<=size; c++)
    {
      g.drawLine (x + c * 50, 150, x + c * 50, 150+size*50);
      g.drawLine (x, 150 + c * 50, x+size*50, 150 + c * 50);
    }
  }
  
  /**
   * Returns the number of columns/rows.
   * @return size
   */
  public int getGridSize (){
    return size;}
}