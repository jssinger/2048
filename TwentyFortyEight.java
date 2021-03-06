import java.util.*;
public class TwentyFortyEight
{
    private static Board game;
    boolean gameOver = false;
    public static Scanner scan = new Scanner(System.in);
    public static void main(String [] args){
        game = new Board();
        game.startGame();
        print(game);
        System.out.println("Next Turn (Example: left or a)");
        String direction = scan.next();
        choice(direction);
        print(game);
        while(game.win()!=true && game.gameOver()!=true){
            direction = scan.next();
            choice(direction);
            print(game);
            System.out.println("Resulting Board");
            game.midGame();
            print(game);
            System.out.println("New Board");
        }
        if(game.win())
            System.out.println("Great Job! You Won!");
        if(game.gameOver())
            System.out.println("You Lose!");
    }

    public static void print(Board game){
        System.out.println(" ________________________________");
        System.out.println("| " +game.cell(0,0)+ " | " +game.cell(0,1)+ " | " +game.cell(0,2)+ " | " +game.cell(0,3)+ " |");
        System.out.println("| " +game.cell(1,0)+ " | " +game.cell(1,1)+ " | " +game.cell(1,2)+ " | " +game.cell(1,3)+ " |");
        System.out.println("| " +game.cell(2,0)+ " | " +game.cell(2,1)+ " | " +game.cell(2,2)+ " | " +game.cell(2,3)+ " |");
        System.out.println("| " +game.cell(3,0)+ " | " +game.cell(3,1)+ " | " +game.cell(3,2)+ " | " +game.cell(3,3)+ " |");
        System.out.println(" _______________________________");
    }

    public static void choice(String choice){
        if(choice.equalsIgnoreCase("left") || choice.equalsIgnoreCase("a")){
            game.left();
        }
        if(choice.equalsIgnoreCase("right")|| choice.equalsIgnoreCase("d")){
            game.right();
        }
        if(choice.equalsIgnoreCase("up")|| choice.equalsIgnoreCase("w")){
            game.up();
        }
        if(choice.equalsIgnoreCase("down")|| choice.equalsIgnoreCase("s")){
            game.down();
        }
    }   
}
