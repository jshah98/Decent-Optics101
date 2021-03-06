/**
 * A location on a grid.
 * @version 2.0.
 * @author Jinansh, Christian.
 * @since 23/05/14.
 * 
 * @param  row stores the row number of location.
 * @param col stores the column number of the location.
 * @param occupied stores whether the location is occupied or nah.
 * @param gameObj stroes the GameObject at this location. 
 */

public class Location
{
  private int row;
  private int col;
  private boolean occupied = true;
  private GameObject gameObj;
  static Grid grid;
  
  /**
   * Creates a new location at specified row and column.
   * @param row stores the row number.
   * @param col stores the column number.
   */
  public Location (int row, int col)
  {
    this.row = row;
    this.col = col;
    this.grid = Game.gameGrid; 
  }
  
  
  /**
   * Inserts gameObject at this location.
   * @param o stores gameObject to be inserted.
   */
//  public void insertGameObject (GameObject o)
//  {
//    if (occupied)
//      occupied = false;
//    else
//    occupied = true;
//  }
  
  /**
   * Removes gameObject from the current location.
   */
//  public void removeGameObject ()
//  {
//    occupied = false;
//  }
  
  /**
   * Returns the row number.
   * @return row.
   */
  public int getRow ()
  {
    return row;}
  
  
 public static int getCol (int y)
 {
   int row=0;
   int x = 964/2- (grid.getGridSize()*50/2);
   for (int c = x; c< x + grid.getGridSize()*50; c+= 50)
   {
     if (y > c && y< c+50){
       return row;
     }
     row++;
   }
   return  row;
 }
  
  
 public void setGameObject (GameObject gameObj)
 {
   this.gameObj = gameObj;
 }
  /**
   * Returns the column number.
   * @return col.
   */
  public int getCol ()
  {
    return col;}
  
  
  public static int getRow (int y )
  {int col=0;
      for (int c = 150; c< 150 + grid.getGridSize()*50; c+= 50)
      {
        if (y > c && y< c+50){
          return col;}
        col++;
      }
      return col;
  }
  
  
  /**
   * This method changes the row number of this location. 
   * @param row stores the new row number. 
   */
  public void setRow (int row)
  {this.row = row;}
  
  
  /**
   * This method changes the column number of this location.
   * @param col stores the new column number. 
   */
  public void setCol (int col)
  {this.col = col;}
  
  
  public boolean equals (Location loc)
  {
      return (loc.getCol  ()== col && loc.getRow () == row); 
  }
  
  /**
   * Returns if the location is occupied or nah.
   * @return occupied.
   */
  public boolean getOccupied()
  {
    return occupied;}
  
  
  
//  /**
//   * This method se
//   */
//  public void setOccupied (boolean occupy)
//  {
//    if (gameObj != null)
//      occupied = true;
  //   else occupied = false;
//  }
  
  
  /**
   * This method returns the GameObject at this location.
   * @return gameObj. 
   */
  public GameObject getGameObj ()
  {
    if (getOccupied())
      return gameObj;
    else return null;
  }
}