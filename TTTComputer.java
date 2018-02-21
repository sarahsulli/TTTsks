/**
 * Sarah Sullivan
 * 20-2-2018
 * 1 period Sos
 */
import java.util.Scanner;
import java.util.Random;

public class TTTComputer {
    public static String originalBoard[][];
    private static int countO=0,countX=0;
    private static Scanner scan = new Scanner(System.in);
    private static boolean gameOver = false;
    private static  long input=0;
    private static long mult;
    private static int computerRow;
    private static int computerCol;
    static boolean winVert = false;    
    Random rand = new Random();
    private static int randX;
    private static int randY;

    public static void main(String[] args) {
        System.out.println("please enter size of board (n)");
        int n = scan.nextInt();
        while(n<2){
            System.out.println("make the board greater than 2");
            n = scan.nextInt();
        }
        mult = n * n;
        originalBoard = new String[n + 1][n + 1];
        showOriginalBoard(n);
        p1Game(n);
    }

    private static boolean ifSameRow(int n) {
        boolean sameRow1 = false;
        for (int row = 1; row <= n; row++) 
        {
            for (int col = 1; col <= n - 1; col++) 
            {
                if (originalBoard[row][col].equals(originalBoard[row][col + 1])) {
                    sameRow1 = true;
                } else {
                    sameRow1 = false;
                    break;
                }
            }
            if (sameRow1 == true) 
            {
                return true;
            }
        }
        return false;
    }

    private static boolean ifSameCol(int n) {
        boolean sameCol1 = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - 1; j++) {
                if (originalBoard[j][i].equals(originalBoard[j + 1][i])) {
                    sameCol1 = true;
                } else {
                    sameCol1 = false;
                    break;
                }
            }
            if (sameCol1 == true) {
                return true;
            }
        }
        return false;
    }

    private void ifwWinVert(int n, int computerRow,int computerCol) 
    {
        for (int row = 1; row <= n; row++) 
        {
            for (int col = 1; col <= n - 2; col++) 
            {
                if (originalBoard[col][row].equals(originalBoard[col + 1][row])
                && (isSafe(row, col +2, n))) 
                {
                    computerRow = row;
                    computerCol = col;
                    winVert = true;
                } 
                else 
                {
                    winVert = false;
                }
            }          
        }    
    }  

    private static boolean ifSameDiagoal1(int n) {
        boolean sameDiag = false;
        for (int i = 1; i <= n - 1; i++) {
            if (originalBoard[i][i].equals(originalBoard[i + 1][i + 1])) {
                sameDiag = true;
            } else {
                sameDiag = false;
                break;

            }
        }
        if (sameDiag == true) {
            return true;
        }
        return false;
    }

    private static boolean ifSameDiagoal2(int n) {
        boolean sameDiag = false;
        for (int i = n; i <= 2; i--) {
            if (originalBoard[i][i].equals(originalBoard[i - 1][i - 1])) {
                sameDiag = true;
            } else {
                sameDiag = false;
                break;

            }
        }
        if (sameDiag == true) {
            return true;
        }
        return false;
    }

    private static void showOriginalBoard(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                originalBoard[i][j] = i + "," + j;
                System.out.print("  " + originalBoard[i][j]);
            }
            System.out.println();
        }
    }

    private static void showBoard(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // originalBoard[i][j]= i +","+ j;
                System.out.print("  " + originalBoard[i][j]);
            }
            System.out.println();
        }
    }

    private static void p1Game(int n) {
        if (input == mult) {
            gameOver = true;
            System.out.println("It's a draw!");
        }
        if (gameOver == false) {
            System.out.println("\n --player 1's turn--");
            System.out.println("please select any place on board in order of number on board {x,y} PICK (X) FIRST, THEN (Y)");
            int player1Row = scan.nextInt();
            int player1col = scan.nextInt();
            if (isSafe(player1Row, player1col, n)) {
                if (!(originalBoard[player1Row][player1col].equals("X  "))
                && !(originalBoard[player1Row][player1col]
                    .equals("O  "))
                && (countX == countO || (countX == (countO + 1)))) {
                    originalBoard[player1Row][player1col] = "X  ";
                    countX++;
                    input++;
                    showBoard(n);
                    if ((ifSameRow(n) == true) || ((ifSameCol(n) == true))
                    || (ifSameDiagoal1(n) == true) || (ifSameDiagoal2(n) == true)) 
                    {
                        System.out.println("Player 1 wins!");
                    } 
                    else 
                    {
                        computerGame(n, computerRow, computerCol);
                    }

                } else {
                    System.out.println("That spot is taken");
                    showBoard(n);
                    p1Game(n);
                }
            } else {
                System.out.println("Out of bounds");
                showBoard(n);
                p1Game(n);
            }
        }
    }    

    public void setRandInput(int n) 
    {
        boolean placed = false;
        int randXTest = rand.nextInt(n);
        int randYTest = rand.nextInt(n);
        if (isSafe(randX, randY, n)) 
        {
            if (!(originalBoard[randXTest][randYTest].equals("X  "))
            && !(originalBoard[randXTest][randYTest]
                .equals("O  "))
            && (countX == countO || (countX == (countO + 1)))) {
                randX = randXTest;
                randY = randYTest;
            }
        }
    }

    private static void computerGame(int n, int computerRow,int computerCol ) {
        if (input == mult) {
            gameOver = true;
            System.out.println("It's a draw!");
        }

        if (gameOver == false) {
            System.out.println("\n --computer's turn--");
            System.out.println("the computer should be picking rn");
            if (winVert==false){
                originalBoard[computerRow][computerCol] = "O  ";
                countO++;
                input++;
                showBoard(n);
                if ((ifSameRow(n) == true) || ((ifSameCol(n) == true))
                || (ifSameDiagoal1(n) == true) || (ifSameDiagoal2(n) == true)) {
                    System.out.println("Player 2 wins!");
                } 
                else 
                {
                    p1Game(n);
                }                   
            }

            else
            {
                originalBoard[randX][randY] = "O  ";
                countO++;
                input++;
                showBoard(n);
                p1Game(n);
            }
        }
    }

    private static boolean isSafe(int i, int j, int n) 
    {
        return (i >= 1 && i <= n && j >= 1 && j <= n);
    }
}