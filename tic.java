import java.util.Scanner;
import java.util.Random;

class Tic {
    
// creating a tic tac toe game so ...
// get input from the user - either X or O 
// and print the board
// let user choose where their input will go on the board (array)
// computer takes a turn and puts an X or O on the board
// recognizes when it's three in a row horizontally, vertically, or diagonally
// when conditions are satisfied, print the winner 

    public static void main(String[] args) {


        char[][] board = {
            {' ', '|',' ', '|', ' '},
            {'-', '+','-', '+', '-'},
            {' ', '|',' ', '|', ' '},
            {'-', '+','-', '+', '-'},
            {' ', '|',' ', '|', ' '}
        };

        printBoard(board);
        char playerChoice = getPlayerChoice();
        boolean gameOver = false;
        printBoard(board);

        while (!gameOver) {

            getUserInput(board, playerChoice);
            printBoard(board);

            if (isGameOver(board)) {
                gameOver = true;
            } else {

                computerTurn(board, (playerChoice == 'X' ? 'O' : 'X'));
                printBoard(board);
                if (isGameOver(board)) {
                    gameOver = true;

                    }
                }
            }
        }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                System.out.print(board[row][col]);

            }
            System.out.println();
        }
    }

    public static char getPlayerChoice() {

        System.out.println();
        System.out.println("Welcome to Tic Tac Toe!");

        Scanner scanner = new Scanner(System.in);
        char choice = ' ';

    while (choice != 'X' && choice != 'O') {
        System.out.println("Please enter X or O: ");
        choice = scanner.nextLine().toUpperCase().charAt(0);

        if (choice != 'X' && choice != 'O') {

            System.out.println("Invalid input. Please enter O or X: ");
        }
    }
    System.out.println("You will play as " + choice + "!");
    return choice;
    }

    public static void getUserInput(char[][] board, char choosePlayer) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row and column (e.g., 1 1): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        boolean validInput = false;

        while (!validInput) {

        if (row >= 1 && row <= 3 && col >= 1 && col <= 3) {

            board[2 * row - 2][2 * col - 2] = choosePlayer;
            validInput = true;
        
    } else {

        System.out.println("Invalid Input. The row and Column should be between 1 and 3.");
        System.out.println("Try again!");
        row = scanner.nextInt();
        col = scanner.nextInt();

    } 
}

    printBoard(board);
    }


    public static void computerTurn(char[][] board, char computerChoice) {
        Random random = new Random();
        int row, col;
        boolean validMove = false;

        while (!validMove) {
            row = random.nextInt(3) + 1;
            col = random.nextInt(3) + 1;

            if (board[2 * row - 2][2 * col - 2] == ' ') {
                board[2 * row - 2][2 * col - 2] = computerChoice;
                validMove = true;

            }


        }

    }

public static boolean isGameOver(char[][] board) {
    // Variable to track if there's a win
    boolean isWin = false;

    // Checking rows
    for (int row = 0; row < 3; row++) {

        if (board[2 * row][0] != ' ' && board[0][2 * row] == board[2][2 * row] && board[0][2 * row] == board[4][2 * row]) {
            System.out.println(board[2 * row][0] + " wins");
            isWin = true;

        }
    }

    // Checking columns
    for (int col = 0; col < 3; col++) {

        if (board[0][2 * col] != ' ' && board[0][2 * col] == board[2][2 * col] && board[0][2 * col] == board[4][2 * col]) {
            System.out.println(board[0][2 * col] + " wins!");
            isWin = true;
        }
    }

    // Checking diagonals
    if (board[0][0] != ' ' && board[0][0] == board[2][2] && board[0][0] == board[4][4]) {

        System.out.println(board[0][0] + " wins!");
        isWin = true;
    }

    if (board[0][4] != ' ' && board[0][4] == board[2][2] && board[0][4] == board[4][0]) {

        System.out.println(board[0][4] + " wins!");
        isWin = true;
    }

    if (isWin) {

        return true;

    }

    return false;

}



}