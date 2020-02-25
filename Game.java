import java.util.*;

public class Game{
  private String name;
  private int uScore;
  private int compScore;
  public int moves;
  private Scanner a;

  public Game(String name){
    this.name = name;
    setMode();
  }
  public void setMode(){

    a = new Scanner(System.in);
    System.out.println("\n"+name + ", Now choose which mode you want to play in...");
    System.out.println("(1) Best of 3\n(2) Best of 5\n(3) Manually Set The Number of Moves\n");
    int mode = 0;
    try{
      mode = a.nextInt();
    }
    catch(Exception e){
      System.out.println("Only numbers are allowed. To exit type 'Exit'");
          String ext = a.next();
          if(ext.equals("Exit"))
            System.exit(0);
          else setMode();
    }

    switch(mode){
      case 1: 
        System.out.println("Off we go to 'Best of 3'!");
        gameTime(3);
        break;
      case 2:
        System.out.println("Off we go to 'Best of 5'!");
        gameTime(5);
        break;
      case 3:
        System.out.println("\nEnter the number of moves you want to play");
        int inp = 0; 
        try{
        inp = a.nextInt();}
        catch(Exception e){
          System.out.println("Only numbers are allowed. To exit type 'Exit'. Else type 'Go'");
          String ext = a.next();
          if(ext.equals("Exit"))
            System.exit(0);
          else if(ext.equals("Go")) setMode();
        }
        System.out.println("\nOff we go to 'Best of "+ inp + "'!");
        gameTime(inp);
        break;
      default:
        System.out.println(name + " Select either 1, 2, or 3, to exit type Exit.");
        if(a.next().equals("Exit")){
          System.exit(0);
        }
        setMode();
    }
  }

  public void uAdd(){
    uScore++;
  }

  public void compAdd(){
    compScore++;
  }

  public void gameTime(int mvs){
    this.moves = mvs;
    do{
      System.out.println("\nRounds Remaining: " + moves);
      Move cMove = compMove();
      System.out.print("\n Choose 1: R: Rock, P: Paper, S: Scissors\n");
      String uMv = a.next();
      Move uMove = new Move(uMv);
      System.out.println(uMove + " - " + cMove);
      scoreCal(cMove,uMove); 
      System.out.println("\nYour Score: " + uScore);
      System.out.println("Comp Score: " + compScore + "\n");
    }while(moves-- > 1);

    if(uScore > compScore)
    System.out.println(name + ", YOU WIN");
    if(uScore == compScore)
    System.out.println("HMM... TIS A DRAW");
    else System.out.println("GAME OVER");
    System.exit(0);
  }
  public Move compMove(){
    return (new Move());
    }
    
public void scoreCal(Move c, Move u){
    if(c.toString().equals("R") && u.toString().equals("S")) compAdd();
    else if(c.toString().equals("R") && u.toString().equals("P")) uAdd();
    else if(c.toString().equals("P") && u.toString().equals("S")) uAdd();
    else if(c.toString().equals("P") && u.toString().equals("R")) compAdd();
    else if(c.toString().equals("S") && u.toString().equals("P")) compAdd();
    else if(c.toString().equals("S") && u.toString().equals("R")) uAdd();
    else if(!u.toString().equals("R")||!u.toString().equals("P")||!u.toString().equals("S")) moves++;
  }
}
