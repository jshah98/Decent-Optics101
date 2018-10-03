import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
/**
 * This class that stores the attributs of a game object.
 * @version 2.0.
 * @author Jinansh, Christian.
 * @since 5/06/14.
 * 
 * @param objImage stores the image of the object.
 * @param objectLocation stores the object's location.
 */
public class GameObject
{
  private Image objImage;
  private Location objectLocation;
  private static Grid grid;
  
  
  public GameObject ()
  {
    objectLocation = new Location (1, 1);
    grid = Game.gameGrid; 
  }
  
  /**
   * The constructor stores the image of the GameObject, the location, and the size of the grid it is on. 
   * @param im stores the image of the GameObject.
   * @param loc stores the location.
   * @param size stores the size of the grid if on.
   */
  public GameObject (Image im, Location loc)
  {
    objImage = im;
    objectLocation = loc;
    this.grid= Game.gameGrid;
  }
  
  public Grid getGrid ()
  {
    return grid;
  }
  
  /**
   * This class draws the GameObject at the specified location. 
   * @param g reference variable to Graphics class.
   */
  public void paint (Graphics g)
  { 
    int x =  964/2- (grid.getGridSize()*50/2) + objectLocation.getCol ()*50;
    int y = 150 + 50*objectLocation.getRow (); 
    g.drawImage (objImage, x, y, 50, 50, null);
  }
  
  
  /**
   * Returns the location of this object.
   * @return objectLocation.
   */
  public Location getObjectLocation ()
  {
    return objectLocation;
  }
  
  /**
   * Changes the location of the GameObject.
   * @param objectLocation stores the new location.
   */
  public void setObjectLocation (Location objectLocation)
  {
    this.objectLocation = objectLocation;
  }
  
  /**
   * This changes the image of the GameObject.
   * @param objImage stores the new Image.
   */
  public void setObjImage (Image objImage)
  {
    this.objImage = objImage;
  }
  
  /**
   * Returns the Image of this GameObject.
   * @return objImage.
   */
  public Image getObjImage ()
  {
    return objImage;
  }
  

}