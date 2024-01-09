import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            gameRound(scanner);

            System.out.println("Do You Want To Play Again? (Y/N): ");
            String playAgainAnswer = scanner.next().toUpperCase();


            if (!playAgainAnswer.equals("Y")) {
                playAgain = false;
            }
        }

        System.out.println("Thank You For Playing Rock Paper Scissors!");
        scanner.close();
    }

    private static void gameRound(Scanner scanner) {

        System.out.println("Welcome to Rock, Paper, Scissors Command Line Game");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        System.out.println("Q. Quit");
        System.out.println("Make Your Selection (1/2/3/Q) and Press Enter: ");

        String userInput = scanner.next().toUpperCase();

        if (userInput.equals("Q")){
            System.out.println("Thank You For Playing Rock Paper Scissors!");
            System.exit(0);
        }

        int UserSelection = parseUserChoice(userInput);

//        scanner.close();

        if (UserSelection < 1 || UserSelection > 3) {
            System.out.println("That is not a valid selection, Please select 1, 2, 3, or Q.");
            return;
        }

        String[] Pool = {"Rock", "Paper", "Scissors"};
        String userSelectionString = Pool[UserSelection - 1];

        String computerChoice = createComputerChoice(Pool);
        System.out.println("Computer Selected: " + computerChoice);

        String outCome = createWinner(userSelectionString, computerChoice);
        System.out.println("Outcome: " + outCome);

    }

    private static int parseUserChoice(String userInput) {
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e){
            return -1;
        }
    }


    private static String createWinner(String UserSelection, String computerChoise) {
        if (UserSelection.equals(computerChoise)){
            return "Outcome is a Draw!";
        }else if ((UserSelection.equals("Rock") && computerChoise.equals("Scissors")) ||
                (UserSelection.equals("Paper") && computerChoise.equals("Rock")) ||
                (UserSelection.equals("Scissors") && computerChoise.equals("Paper"))){
            return "You Won!";
        }else {
            return "You Lost!";
        }

    }

    private static String createComputerChoice(String[] Pool) {
        Random random = new Random();
        int randomNumber = random.nextInt(Pool.length);
        return Pool[randomNumber];
    }
}
