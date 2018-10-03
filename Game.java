import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.*;
/**
 * This class runs the game itself.
 * 
 * @version 1.0.
 * @author Jinansh, Christian.
 * @since 5/06/14.
 * 
 * @param size stores the size of the grid.
 * @param background stores the background screen (Image).
 * @param gameGrid stores the grid that the game will be played on.
 * @param x stores the x coordinate of the object being moved.
 * @param y stores the y coordinate of the object being moved.
 * @param im stores the image on one of the game objects. 
 * @param im2 stores the image on one of the game objects. 
 * @param gameObj stores one of the GameObject used in game. 
 * @param gameObj2 stores one of the GameObject used in game. 
 * 
 */
public class Game extends JPanel implements MouseMotionListener, MouseListener, ActionListener
{
  
  Image background;
  static int size = 7;
  static Grid gameGrid = new Grid (size);
  int x ;
  int y ;
  Image im;
  static ArrayList <GameObject> gameObjs = new ArrayList <GameObject>();
  ArrayList <Location> opaqueLocs = new ArrayList <Location>();
  GameObject temp;
  Laser laser;
  Image im2;
  Graphics g;
  
  /**
   * The constructor stores the images to their variables and starts the game.
   * @throws IOException when image cannot be stored.
   */
  public Game ()
  {
    try
    {
      background= ImageIO.read (getClass().getResource ("mainBackGround3.jpg"));
    }
    catch (IOException e) { return; }
    try
    {
     im2= ImageIO.read (getClass().getResource ("Opaque7by7.png"));
     GameObject tmp = new GameObject (im2, new Location (4, 5));
     tmp.getObjectLocation ().setGameObject (tmp);
     gameObjs.add (tmp);
     opaqueLocs.add (tmp.getObjectLocation());
    }
    catch (IOException e) { System.exit (0); }
try
    {
     im= ImageIO.read (getClass().getResource ("Opaque7by7.png"));
     GameObject tmp = new GameObject (im, new Location (1, 1));
     tmp.getObjectLocation ().setGameObject (tmp);
     gameObjs.add (tmp);
     opaqueLocs.add (tmp.getObjectLocation());
    }
    catch (IOException e) { return; }
    try
    {
     im= ImageIO.read (getClass().getResource ("Mirrors7by7.png"));
     Mirror tmp = new Mirror(im, new Location (7, 3));
     tmp.getObjectLocation ().setGameObject (tmp);
     gameObjs.add (0,tmp);
    }
    catch (IOException e) { return; }
    try
    {
     im= ImageIO.read (getClass().getResource ("Mirrors7by7.png"));
     Mirror tmp = new Mirror(im, new Location (5, 3));
     tmp.getObjectLocation ().setGameObject (tmp);
     gameObjs.add (0,tmp);
    }
    catch (IOException e) { return; }
    laser = new Laser (45, 4, new Location (3, 3));
    game ();
  }
  
  
  /**
   * This method add MouseListener and MouseMotionListener to this JPanel and draws the game board.
   */
  public void game ()
  {
    this.addMouseMotionListener (this);
    this.addMouseListener (this);
    //JButton laserButton = new JButton ("Laser");
   // setLayout (null);
    //laserButton.addActionListener (this);
    //add (laserButton);
    //laserButton.setBounds (100, 100, 100, 40);
    x = 200;
    y = 200;
    add (gameGrid);
    repaint ();
  }
  
  /**
   * This method draws the background, the grid and the GameObjects.
   * @param g reference variablt of Graphics class.
   */
  public void paint (Graphics g)
  {
    super.paintComponent(g); 
    g.drawImage(background,0,0,null);
    gameGrid.paint (g);
      for (int i = 0; i < gameObjs.size (); i ++)
      {
        gameObjs.get(i).paint (g);
      }
      
      laser.paint (g);
  }
  
  
  
  public void actionPerformed (ActionEvent e)
  {
    
  }
  public void mouseDragged (MouseEvent e) 
  {
  }
  public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    /**
     * This method process the next location of the GameObject.
     * @param e reference variable of the MouseEvent class.
     */
    public void mouseClicked(MouseEvent e) {
      Location newLoc = new Location ( Location.getRow (e.getY()), Location.getCol (e.getX()));
      
      for (int i = 0; i < opaqueLocs.size (); i++)
      {
        if (opaqueLocs.get (i).equals (newLoc))
          return;
      }
      for (int i = 0; i < gameObjs.size (); i++)
      {
        if (gameObjs.get (i).getObjectLocation().equals (newLoc) && gameObjs.get(i) instanceof Mirror){
          temp = gameObjs.get (i);
          break;
        }
      }
      if (temp != null)
      {
      int x = 964/2- (size*50/2);
      if (e.getX () < x+size*50 && e.getX () > x && e.getY() > 150 && e.getY ()< 150+size*50){
      this.x = formatX (e.getX());
      y = formatY (e.getY());
      }
      repaint ();
      }
    }
    
    /**
     * This method sets the appropriate location of the object and returns the formatted x coordinate of the GameObject.
     * @param y stores the original coordinate.
     * @return x (the altered coordinate). 
     */
    public int formatX (int y)
    {
      int col=0;
      int x = 964/2- (size*50/2);
      for (int c = x; c< x + size*50; c+= 50)
      {
        if (y > c && y< c+50){
          temp.getObjectLocation().setCol (col);
          return c;}
        col++;
      }
       return this.x; 
    }
    
        /**
     * This method sets the appropriate location of the object and returns the formatted y coordinate of the GameObject.
     * @param y stores the original coordinate.
     * @return y (the altered coordinate). 
     */
    public int formatY (int y){
      int row=0;
      for (int c = 150; c< 150 + size*50; c+= 50)
      {
        if (y > c && y< c+50){temp.getObjectLocation().setRow (row);
          return c;}
        row++;
      }
    return this.y;
    }
  
  public void mouseMoved (MouseEvent e){}

}