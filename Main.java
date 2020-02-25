import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner a = new Scanner(System.in);

    System.out.println("Hi, I'm Thunderhead, what is your name?");
    String name = a.nextLine();

    System.out.println("\nHello " + name + ", Let the games begin!");
    Game game = new Game(name);
  }
}
