/** 
 * The game that uses a n x m board of tiles or cards.
 *  
 * Player chooses two random tiles from the board. The chosen tiles
 * are temporarily shown face up. If the tiles match, they are removed from board.
 * 
 * Play continues, matching two tiles at a time, until all tles have been matched.
 * 
 * @author PLTW
 * @version 2.0
*/
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * A game class to play concentration
 */
public class Game
{
  private Scanner in = new Scanner(System.in);
  private Random rd = new Random(); // creating Random object
  private Board board;
  private BoardP2 boardP2;
  private int row1, col1;
  private int row2, col2;
  private boolean vsPC;
  private String playersChar;
  private String player1Char;
  private String player2Char;
  private boolean won = false;
  private static String[] questions = {"Jedi",	"Droid",	"HumanLike",	"Wookie",	"Dark Side",	"Light Side",	"Bounty Hunter",	"Smuggler",	"Kessel Speed",	"Empire	Rebel",	"Resistance",	"First Order",	"Separatist",	"Galactic Republic",	"Ewok",	"Fluffy",	"Slimey",	"Tall",	"Short",	"Pilot",	"Annoying",	"Cute",	"Bander's Fav",	"Got Butt Whooped",	"Inside A Tauntaun",	"Still Living",	"Lost A Limb",	"Space Balls Character","Red lightsaber","Blue lightsaber", "Purple lightsaber", "Yellow lightsaber", "Green lightsaber"};
  private static String[] characters = {"Admiral Ackbar","Admiral Holdo","Admiral Piett","Ahsoka Tano","BB-8","Biggs Darklighter","Boba Fett","Bossk","C-3PO","Chewbacca","Chirrut Imwe","Count Dooku","Darth Maul","Darth Vader","Dengar","Droideka","Emperor Palpatine","Enfys Nest","Ezra Bridger","Finn","General Grievous","Grand Moff Tarkin","Greedo","Han Solo","IG-11","Jabba the Hut","Jango Fett","Jar Jar Binks","K2SO","Ki-Adi-Mundi","Kylo Ren","Lando Calrissian","Luke Skywalker","Mace Windu","Mon Mothma","Nute Gunray","Obi-Wan Kenobi","Padme Amidala","Plo Koon","Poe Dameron","Princess Leia","Qira","Qui-Gon Jinn","R2-D2","Anakin Skywalker","Rex","Rey","Wedge Antilles","Wicket","Yoda"};

  public void play()
  {
    List<Characters> character = new ArrayList<Characters>();
    populateChar(character);
    // instructions
    System.out.println("Welcome!");
    System.out.println("type in a your charcter's name");
    System.out.println("then you will type in parameters to find opponents character");
    System.out.println("if you think you know the character type guess the the name of character.");
    System.out.println("\nPress Enter to continue...");
    in.nextLine();
    gameMenu();
    
    board = new Board();
    boardP2 = new BoardP2();
    displayBoard();
    //play against CPU
    if (vsPC == true){
      //System.out.println("pc succesfully tru");
      String pcCharacter = characters[new Random().nextInt(characters.length)];
      boolean test = false; 
      //Lets user pick their character
      while(test==false){
        System.out.println("Enter a valid characters name:");
        playersChar= in.nextLine();
          for(String c: characters) { 
            if (c.equals(playersChar)) { 
                test = true; 
                break; 
            } 
        }
        }
        //keeps running until someone wins
      while(won==false){
        //User can put in a parameter or guess the character
        System.out.println("Guess a parameter(in lower case) ex.'dark side' or enter 'guess' to guess character name.");
        String guess = in.nextLine();
        if (guess.equals("guess")){
          System.out.println("Enter character name:");
          guess = in.nextLine();
          if (guess.equals(pcCharacter)){
            System.out.println("You Win!!!");
            quitGame();
          }
          else{
            System.out.println("Incorrect!");
          }
        }
        else{
          //finds if parameter entered matches that of the CPU character
          boolean contains=false;
          for(Characters c: character){
            if(c.getName().equals(pcCharacter)){
              if(c.getDesc().contains(guess)){
                contains=true;
              }
              else{
                contains=false;
              }
            }
          }
          yesOrNo(guess, contains, character);
        }
        //update board
        displayBoard();
        //the CPU will randomly either try to guess the character or ask a question about them
        boolean choice= rd.nextBoolean();
        if(choice==true){
          String pcChoice = questions[new Random().nextInt(questions.length)];
          System.out.println(pcChoice+"?");
          System.out.println("Enter Y/N: ");
          String yN = in.nextLine();
        }
        else{
          String pcGuess=characters[new Random().nextInt(characters.length)];
          System.out.println("The PC guesses "+ pcGuess);
          if (pcGuess.equals(playersChar)){
            System.out.println("You Lose.");
            quitGame();
        }
        }

        

      }
    }
    //PvP
    else{
      //lets player 1 set their character
      boolean testP2=false;
      while(testP2==false){
        System.out.println("Player 1: Enter a valid characters name:");
        player1Char= in.nextLine();
          for(String c: characters) { 
            if (c.equals(player1Char)) { 
                testP2 = true; 
                break; 
            } 
        }
      }
      //lets player 2 set their character
      testP2=false;
      while(testP2==false){
        System.out.println("Player 2: Enter a valid characters name:");
        player2Char= in.nextLine();
          for(String c: characters) { 
            if (c.equals(player2Char)) { 
                testP2 = true; 
                break; 
            } 
        }
      }
      //runs until one wins
      while(won==false){
        displayBoard();
        //Player 1 turn prints their board and lets them enter parameters
        System.out.println("Player 1's turn");
        System.out.println("Player 1: guess a parameter(in lower case) or enter 'guess' to guess character name.");
        String guessWho = in.nextLine();
        if (guessWho.equals("guess")){
          System.out.println("Enter character name:");
          guessWho = in.nextLine();
          if (guessWho.equals(player2Char)){
            System.out.println("Player 1 Wins!!!");
            quitGame();
          }
          else{
            System.out.println("Incorrect!");
          }
        }
        else{
          boolean contains=false;
          for(Characters c: character){
            if(c.getName().equals(player2Char)){
              if(c.getDesc().contains(guessWho)){
                contains=true;
              }
              else{
                contains=false;
              }
            }
          }
          System.out.println("Player 2: Enter Y/N: ");
          String yN = in.nextLine();
          yesOrNo(guessWho, contains, character);
        }
        displayBoard();
        //waits to let player see their board befor it changes to player 2
        wait(3);
        //Player 2 turn prints their board and lets them enter parameters
        displayBoardP2();
        System.out.println("Player 2's turn");
        System.out.println("Player 2: guess a parameter(in lower case) or enter 'guess' to guess character name.");
        String guessWho2 = in.nextLine();
        if (guessWho2.equals("guess")){
          System.out.println("Enter character name:");
          guessWho2 = in.nextLine();
          if (guessWho2.equals(player2Char)){
            System.out.println("Player 2 Wins!!!");
            quitGame();
          }
          else{
            System.out.println("Incorrect!");
          }
        }
        else{
          boolean contains=false;
          for(Characters c: character){
            if(c.getName().equals(player1Char)){
              if(c.getDesc().contains(guessWho2)){
                contains=true;
              }
              else{
                contains=false;
              }
            }
          }
          System.out.println("Player 2: Enter Y/N: ");
          String yN = in.nextLine();
          yesOrNo2(guessWho2, contains, character);
        }
        displayBoardP2();
        wait(3);
    }
    }
  }

  
  /**
   * Clear the console and show the game board
   */
  public void displayBoard()
  {

    // scroll current board off screen
    for (int x = 0; x < 50; x++) {
      System.out.println();
    }

    System.out.println(board);
  }

  public void displayBoardP2()
  {

    // scroll current board off screen
    for (int x = 0; x < 50; x++) {
      System.out.println();
    }

    System.out.println(boardP2);
  }

  /**
   * Wait n seconds before clearing the console
   */
  private void wait(int n)
  {
    // a try is like an if statement, "throwing" an error if the body of the try fails
    try
    {
      Thread.sleep(n * 1000);
    } catch (InterruptedException e) { /* do nothing */ }
  }

  /** 
   * User quits game
   */
  private void quitGame() 
  {
    System.out.println("Quit game!");
    System.exit(0);
  }

  public void gameMenu(){
    //give the option to for the user on single or two player
    System.out.println("1: for single player\n2: for two players\n3: for quit\n");
    //have an event to run the choose who goes first methods (get and set player)
    int menuSelection = in.nextInt();
    if(menuSelection==1){
        this.vsPC=true;     //since vsPC is private in in an object of a class we have to us "this"
    }
    else if(menuSelection==2){
        this.vsPC=false;
    }
    else{
        System.out.println("Shutting down............");
        System.exit(1);
    }
    
  }
  //adds all class to an ArrayList
  public static void populateChar(List<Characters> character)
    {
        character.add(new AdmiralAckbar());
        character.add(new AdmiralHoldo());
        character.add(new AdmiralPiett());
        character.add(new AhsokaTano());
        character.add(new BB8());
        character.add(new BiggsDarklighter());
        character.add(new BobaFett());
        character.add(new Bossk());
        character.add(new C3PO());
        character.add(new Chewbacca());
        character.add(new ChirrutImwe());
        character.add(new CountDooku());
        character.add(new DarthMaul());
        character.add(new DarthVader());
        character.add(new Dengar());
        character.add(new Droideka());
        character.add(new EmperorPalpatine());
        character.add(new EnfysNest());
        character.add(new EzraBridger());
        character.add(new Finn());
        character.add(new GeneralGrievous());
        character.add(new GrandMoffTarkin());
        character.add(new Greedo());
        character.add(new HanSolo());
        character.add(new IG11());
        character.add(new JabbatheHut());
        character.add(new JangoFett());
        character.add(new JarJarBinks());
        character.add(new K2SO());
        character.add(new KiAdiMundi());
        character.add(new KyloRen());
        character.add(new LandoCalrissian());
        character.add(new LukeSkywalker());
        character.add(new MaceWindu());
        character.add(new MonMothma());
        character.add(new NuteGunray());
        character.add(new ObiWanKenobi());
        character.add(new PadmeAmidala());
        character.add(new PloKoon());
        character.add(new PoeDameron());
        character.add(new PrincessLeia());
        character.add(new Qira());
        character.add(new QuiGonJinn());
        character.add(new R2D2());
        character.add(new AnakinSkywalker());
        character.add(new Rex());
        character.add(new Rey());
        character.add(new WedgeAntilles());
        character.add(new Wicket());
        character.add(new Yoda());
    }

  //Based on whether the question or parameter matches the character it will hide some character choices
    public void yesOrNo(String guess, boolean contains, List<Characters> character){
    if(contains==true){
      System.out.println("The character has this trait!");
      for(Characters c: character){
            if(!(c.getDesc().contains(guess))){
              //System.out.println(c.getName());
              board.eliminate(c.getName());
            }

          }
    }
    else{
      System.out.println("The character does not have this trait!");
      for(Characters c: character){
            if(c.getDesc().contains(guess)){
              //System.out.println(c.getName());
              board.eliminate(c.getName());
            }

          }
    }
    }

    public void yesOrNo2(String guess, boolean contains, List<Characters> character){
    if(contains==true){
      System.out.println("The character has this trait!");
      for(Characters c: character){
            if(!(c.getDesc().contains(guess))){
              //System.out.println(c.getName());
              boardP2.eliminate(c.getName());
            }

          }
    }
    else{
      System.out.println("The character does not have this trait!");
      for(Characters c: character){
            if(c.getDesc().contains(guess)){
              //System.out.println(c.getName());
              boardP2.eliminate(c.getName());
            }

          }
    }
    }
}
