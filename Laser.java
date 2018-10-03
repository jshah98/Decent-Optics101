import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.*;
public class Laser extends GameObject 
{
  private int direction;
  private int side;
  
  public Laser (int d, int side, Location loc){
    super (null, loc);
    direction =     formatDirection (d);
    this.side = formatSide (side);
  }
  
  private int formatDirection (int dir)
  {
    while (dir > 360)
    {
      dir -= 90;
    }
    dir = dir- ((dir-45)% 90);
    if (dir < 0)
      dir += 360;
    return dir;
  }
  
  private int formatSide (int side)
  {
    side = side %4;
    if (side <= 0)
      side += 4;
    if (direction == 45)
    {
      if (side == 3 || side == 1)
        side = 1;
      else{ if (side == 4 ||side == 2)
        side = 4;
      }
    }
    else if (direction == 135)
    {
      if (side == 4|| side == 1)
        side = 4;
      else {if (side == 3|| side == 2) side = 2;}
    }
    else if (direction == 225){
      if (side == 3|| side == 1)
        side = 3;
      else {if (side == 4|| side == 2) side = 2;}
    }
    else
    {
      if (side == 1|| side == 4)
        side = 1;
      else {if (side == 2|| side == 3) side = 3;}
    }
    return side;
  }
  public int getDirection (){
    return direction;
  }
  
  public void paint (Graphics g)
  {
    int x =  964/2- (getGrid().getGridSize()*50/2) + getObjectLocation().getCol()*50;
    int y = 150 + 50*getObjectLocation().getRow (); 
    g.setColor (Color.RED);
    if (side == 1)
    {
      x+= 25;
    }
    else if (side == 2){
      x+= 25; 
      y+= 50;
    }
    else if (side ==3){
      y+= 25;
    }
    else{
      if (side == 4){
        y+= 25;
        x+= 50;
      }
    }
    int xInc = 0; 
    int yInc = 0;
    if (direction == 45)
    {
      xInc = 1;
      yInc = -1;
    }
    else if (direction == 135)
    {
      xInc = 1;
      yInc = 1;
    }
    else if (direction == 225)
    {
      xInc = -1;
      yInc = 1;
    }
    else {
      if (direction == 315)
      {
        xInc = -1; 
        yInc = -1;
      }
    }
    //int q = getGrid().getGridSize()*50; 
    int q = distance (g);
    for (int i = 0; i < q; i++)
    {
      g.drawLine ( x, y, x+xInc, y+yInc);
      x+= xInc;
      y+= yInc;
    }
  }
  
  
  public Location change1 (Location loc, int d)
  {
    return null; 
  }
  
  
  public int distance (Graphics g)
  {
    Location loc = this.getObjectLocation ();
    int newSide = 1;
    Location newLoc= null;
    int change = 0;
    GameObject obj = null;
    int distance = Game.gameGrid.getGridSize ()*50;
    loop:{
      for (int d = 1; d < getGrid().getGridSize (); d++){
        distance = (d-1) * 50;
        if (getDirection()==45)
        {
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get (i).getObjectLocation ().equals (new Location (loc.getRow()-d, loc.getCol()-1+d) ) && side == 1){
              change = 135;
              newSide = 2;
              newLoc = new Location (loc.getRow()-d, loc.getCol()-1+d);
              obj = Game.gameObjs.get (i);
              break loop;
            }
          }
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get (i).getObjectLocation ().equals (new Location (loc.getRow()+1-d, loc.getCol()+d )) && side == 4){
              change = 315;
              newSide = 3;
              newLoc = new Location (loc.getRow()+1-d, loc.getCol()+d );
              obj = Game.gameObjs.get (i);
              break loop;
            }
          }
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get(i).getObjectLocation().equals (new Location (loc.getRow()-d, loc.getCol()+d ))){
              newLoc = new Location (loc.getRow()-d, loc.getCol()+d );
              distance += 25;
              obj = Game.gameObjs.get (i);
              if (side == 4)
              {                
                change = 135;
                newSide = 2;
                break loop;
              }
              else { 
                change = 315;
                newSide = 3;
                break loop;
              }
            }
          }
        }
        else if (getDirection()==135)
        {
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get (i).getObjectLocation ().equals (new Location (loc.getRow()+d, loc.getCol()-1+d) ) && side == 2){
              change = 45;
              newSide = 1;
              obj = Game.gameObjs.get (i);
              newLoc = new Location (loc.getRow()+d, loc.getCol()-1+d);
              break loop;
            }
          }
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get (i).getObjectLocation ().equals (new Location (loc.getRow()-1+d, loc.getCol()+d )) && side == 4){
              change = 225;
              newSide = 3;
              newLoc = new Location (loc.getRow()-1+d, loc.getCol()+d );
              obj = Game.gameObjs.get (i);
              break loop;
            }
          }
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get(i).getObjectLocation().equals (new Location (loc.getRow()+d, loc.getCol()+d ))){
              newLoc = new Location (loc.getRow()+d, loc.getCol()+d );
              distance +=25;
              obj = Game.gameObjs.get (i);
              if (side == 4)
              {                
                change = 45;
                newSide = 1;
                break loop;
              }
              else { 
                change = 225;
                newSide = 3;
                break loop;
              }
            }
          }
        }
        else if (getDirection()==225)
        {
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get (i).getObjectLocation ().equals (new Location (loc.getRow()+d, loc.getCol()+1-d) ) && side == 2){
              change = 315;
              obj = Game.gameObjs.get (i);
              newSide = 1;
              newLoc = new Location (loc.getRow()+d, loc.getCol()+1-d);
              break loop;
            }
          }
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get (i).getObjectLocation ().equals (new Location (loc.getRow()-1+d, loc.getCol()-d )) && side == 3){
              change = 135;
              newSide = 4;
              obj = Game.gameObjs.get (i);
              newLoc = new Location (loc.getRow()-1+d, loc.getCol()-d );
              break loop;
            }
          }
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get(i).getObjectLocation().equals (new Location (loc.getRow()+d, loc.getCol()-d ))){
              newLoc = new Location (loc.getRow()+d, loc.getCol()-d );
              distance +=25;
              obj = Game.gameObjs.get (i);
              if (side == 3)
              {                
                change = 315;
                newSide = 1;
                break loop;
              }
              else { 
                change = 135;
                newSide = 4;
                break loop;
              }
            }
          }
        }
        else
        {
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get (i).getObjectLocation ().equals (new Location (loc.getRow()-d, loc.getCol()+1-d) ) && side == 1){
              change = 225;
              newSide = 2;
              obj = Game.gameObjs.get (i);
              newLoc = new Location (loc.getRow()-d, loc.getCol()+1-d);
              break loop;
            }
          }
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get (i).getObjectLocation ().equals (new Location (loc.getRow()+1-d, loc.getCol()-d )) && side == 3){
              change = 45;
              newSide = 4;
              obj = Game.gameObjs.get (i);
              newLoc = new Location (loc.getRow()+1-d, loc.getCol()-d );
              break loop;
            }
          }
          for (int i = 0; i < Game.gameObjs.size (); i++)
          {
            if (Game.gameObjs.get(i).getObjectLocation().equals (new Location (loc.getRow()-d, loc.getCol()-d ))){
              newLoc = new Location (loc.getRow()-d, loc.getCol()-d );
              distance += 25;
              obj = Game.gameObjs.get (i);
              if (side == 3)
              {                
                change = 225;
                newSide = 4;
                break loop;
              }
              else { 
                change = 45;
                newSide = 2;
                break loop;
              }
            }
          }
        }
      }
    }
    if (newLoc != null && obj instanceof Mirror)
    {
      try{
      (new Laser (change, newSide, newLoc)).paint (g);
      }
      catch (StackOverflowError e)
      {}
    }
    return distance;
  }
  
  public void setDirection (int dir)
  {
    direction = formatDirection (dir);
  }
  
}