/*
name: Minh Phan
ID:300269120
*/
import java.util.*;


public class Game {
  
  private Grid grid;
  private int userRow;
  private int msElapsed;
  private int timesGet;
  private int timesAvoid;
  public static final int maxRow = 5;
  public static final int maxCol = 10;
  public static final String userImage = "user.gif";
  public static final String getScore = "gift.png";
  public static final String minusScore = "alien.gif";

  public Game() {
    grid = new Grid(maxRow, maxCol);
    userRow = 0;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setImage(new Location(userRow, 0), userImage);

  }

  public void play()
  {

    while (!isGameOver())
    {
      grid.pause(100);
      handleKeyPress();
      if (msElapsed % 300 == 0)
      {
        scrollLeft();
        populateRightEdge();
      }
      updateTitle();
      msElapsed += 100;
    }
  }

  public void handleKeyPress() {
    
    int key = grid.checkLastKeyPressed();
    //default loc
    Location myLoc = new Location(userRow, 0);
   
    if (key == 38) { 
     
      userRow--;
      
      Location moveUp = new Location(userRow, 0);
      handleCollision(moveUp);
      
      grid.setImage(moveUp, userImage);
      grid.setImage(myLoc, null);
    } 
    else if (key == 40) { 
      userRow++;
      Location moveDown = new Location(userRow, 0);
      handleCollision(moveDown);
    
      grid.setImage(moveDown, userImage);
      grid.setImage(myLoc, null);
    } // end if

  }

  public void populateRightEdge() {
      int row = (int)(Math.random() * 5);
      int col = maxCol -1 ;
      int chance = (int)(Math.random() * 100);
      if(chance > 50){
          grid.setImage(new Location(row, col), getScore);
      }else if(chance < 50){
          grid.setImage(new Location(row, col), minusScore);
      }
  }

  public void scrollLeft() {
  
    Location playerLoc = new Location(userRow, 0);
    
    for (int r = 0; r < maxRow; r++) {
      for (int c = 0; c < maxCol; c++) {
      //holding player
        Location currentLoc = new Location(r, c);
         
        if (!currentLoc.equals(playerLoc)) {
          int currentCol = c - 1 ;
          Location newLoc = new Location(r, currentCol);
         
          if (currentCol < 0) {
            grid.setImage(currentLoc, null);
          } 
          else if (!currentLoc.equals(new Location(userRow, 1))) {
            grid.setImage(newLoc, grid.getImage(currentLoc));
          } 
          if (c == maxCol - 1) {
            grid.setImage(currentLoc, null);
          } //elemination the crowded side
        }//end if

        if (currentLoc.equals(new Location(userRow, 1))){
          handleCollision(currentLoc);
        }
      }//end for cols
    }//end for rows
  }//end method

  public void handleCollision(Location loc) {
    
      if (grid.getImage(loc) != null) {
        if (grid.getImage(loc) == getScore) {
          timesGet++;
        } 
        else if (grid.getImage(loc) == minusScore) {
          timesAvoid++;
        }
        grid.setImage(loc, null);
      }
  }

  public int getScore() {
    return (timesGet - (timesAvoid * 4)) * (msElapsed / 300);
  }

  public void updateTitle() {
    grid.setTitle("Game's Score: " + getScore());
  }

  public boolean isGameOver() {
    if (getScore()< -1000){
      System.out.println("YOU LOSE!!!");
      return true;
    }
    return false;
  }

  public static void test() {
    Game game = new Game();
    game.play();

  }

  public static void main(String[] args) {
    test();

  }
}