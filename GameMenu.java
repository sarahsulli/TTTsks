import java.util.Scanner;

public class GameMenu
{

    public static void main(String args[]){
        //TTTComputer tC = new TTTComputer();        
        //TTTHuman tH = new TTTHuman();
        Scanner prompt = new Scanner(System.in);

        System.out.println("What kind of Game do you want to play?");
        System.out.println("(1) Player vs Computer");
        System.out.println("(2) Player vs Player");        
        int decision = prompt.nextInt();
        if(decision == 1){
            TTTComputer.main(args);
        }
        else if(decision == 2){
            TTTHuman.main(args);
        }
        else{
            System.out.println("pick something else");
        }
        System.out.println("Play again? (yes) or (no)?");
        String a = prompt.next();
        while(a.equals("yes")) {
            System.out.println("What kind of Game do you want to play?");
            System.out.println("(1) Player vs Computer");
            System.out.println("(2) Player vs Player");  
            decision = prompt.nextInt();
            if(decision == 1){
                TTTComputer.main(args);
            }
            else if(decision == 2){
                TTTHuman.main(args);
            }
            else{
                System.out.println("pick something else");
            }
            System.out.println("Play again? (yes) or (no)");
            a = prompt.next();
        }
        prompt.close();
        System.out.println("Thanks for playing!");
    }

}