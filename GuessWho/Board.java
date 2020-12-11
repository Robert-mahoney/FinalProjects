

/** 
 * A game board of NxM board of tiles.
 * 
 *  @author PLTW
 * @version 2.0
 */

/** 
 * A Board class for concentration
 */
public class Board
{  
  private static String[] tileValues = {"Admiral Ackbar","Admiral Holdo","Admiral Piett","Ahsoka Tano","BB-8","Biggs Darklighter","Boba Fett","Bossk","C-3PO","Chewbacca","Chirrut Imwe","Count Dooku","Darth Maul","Darth Vader","Dengar","Droideka","Emperor Palpatine","Enfys Nest","Ezra Bridger","Finn","General Grievous","Grand Moff Tarkin","Greedo","Han Solo","IG-11","Jabba the Hut","Jango Fett","Jar Jar Binks","K2SO","Ki-Adi-Mundi","Kylo Ren","Lando Calrissian","Luke Skywalker","Mace Windu","Mon Mothma","Nute Gunray","Obi-Wan Kenobi","Padme Amidala","Plo Koon","Poe Dameron","Princess Leia","Qira","Qui-Gon Jinn","R2-D2","Anakin Skywalker","Rex","Rey","Wedge Antilles","Wicket","Yoda"}; 
  private Tile[][] gameboard = new Tile[5][10];
  

  /**  
   * Constructor for the game. Creates the 2D gameboard
   * by populating it with card values
   * 
   */
  public Board()
  {
   //step 14 3.8.
   
   int tileCount=0;
    for(int r=0;r<gameboard.length;r++){    //row
      for(int c=0;c<gameboard[0].length;c++){   //column
          gameboard[r][c] = new Tile(tileValues[tileCount]) ;
          tileCount++;
      }
    }
    System.out.println(toString());
  }

    
    //System.out.println(java.util.Arrays.toString(gameboard[0]));
    //System.out.println(java.util.Arrays.toString(gameboard[1]));
    //System.out.println(java.util.Arrays.toString(gameboard[2]));
    /*
    int tileCount = tileValues.length-1;
    for(int r=0;r<gameboard.length;r++){    //row
      for(int c=0;c<gameboard[0].length;c++){   //column
        int ra =(int)(Math.random()*tileCount);
        gameboard[r][c]= new Tile(tileValues[ra]);
        tileValues[ra] = tileValues[tileCount];
        tileCount--;
      }
    }


  }
*/
 /** 
   * Returns a string representation of the board, getting the state of
   * each tile. If the tile is showing, displays its value, 
   * otherwise displays it as hidden.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return a string represetation of the board
   */
  public String toString()
  {
    String returnVal= "";
    for(Tile[] row: gameboard){    //row
      for(Tile tile: row){   //column
        if(tile.isShowingValue()){
        returnVal += tile.getValue(); //gameboard[r][c]+" ";
        }
        else{
          returnVal += tile.getHidden();
        }
        returnVal+= ("\t | ");
      }
      returnVal+= ("\n");
    }
    
    return returnVal;
  }

  /** 
   * Determines if the board is full of tiles that have all been matched,
   * indicating the game is over.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return true if all tiles have been matched, false otherwse
   */
  public boolean allTilesMatch()
  {

    for(Tile[] row: gameboard){    //row
      for(Tile tile: row){
        if(!tile.matched()){
          return false;
        }
        }
      }
      return true;
    }
    
    
  

  /** 
   * Sets the tile to show its value (like a playing card face up)
   * 
   * Preconditions:
   *   gameboard is populated with tiles,
   *   row values must be in the range of 0 to gameboard.length,
   *   column values must be in the range of 0 to gameboard[0].length
   * 
   * @param row the row value of Tile
   * @param column the column value of Tile
   */
  public void showValue (int row, int column)
  {
   
    gameboard[row][column].show();
  }  

  //hides character that can be eliminate from being the correct character
  public void eliminate(String name)
  {
    for(Tile[] row: gameboard){    //row
      for(Tile tile: row){
        if(tile.getValue().equals(name)){
          tile.hide();
        }
      }
    }
    
     
  }

  /** 
   * Checks the provided values fall within the range of the gameboard's dimension
   * and that the tile has not been previously matched
   * 
   * @param rpw the row value of Tile
   * @param col the column value of Tile
   * @return true if row and col fall on the board and the row,col tile is unmatched, false otherwise
   */
  public boolean validateSelection(int row, int col)
  {

    if(row>=gameboard.length){
      return false;
    }
    if(col>=gameboard[0].length){
      return false;
    }
    if(gameboard[row][col].matched()){
      return false;
    }

    return true;
  }

}
