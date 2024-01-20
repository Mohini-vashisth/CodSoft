package CodSoft;


import java.util.*;

class Guess {
    public void guessingNumberGame(int K){
		
        Scanner sc = new Scanner(System.in);

        int number = 1 + (int)(100 * Math.random());
        int i, guess;

        System.out.println("A number is chosen between 1 to 100." + " Guess the number within " + K + " trials.");

        for (i = 0; i < K; i++) {

            System.out.println ("Guess the number:");
            guess = sc.nextInt();

            if (guess > 100) {
                System.out.println("The number is between 0 and 100. Please provide a valid input.");
                i--;
                continue;
            }

            if (number == guess) {
            System.out.println("Congratulations!" + " You guessed the number.");
            break;
            }
            else if (number > guess && i != K - 1) {
            System.out.println("The number is " + "greater than " + guess);
            }
            else if (number < guess && i != K - 1) {
            System.out.println("The number is" + " less than " + guess);
            }

            System.out.println((K-i-1) + " trials left");
        }

        if (i == K) {
            System.out.println("You have exhausted " + K + " trials.");
            System.out.println("The number was " + number);
        } 
    }
}

class Easy extends Guess{
    @Override
    public void guessingNumberGame(int K) {
        super.guessingNumberGame(K);
    }
}

class Medium extends Guess{
    @Override
    public void guessingNumberGame(int K) {
        super.guessingNumberGame(K);
    }
}

class Hard extends Guess{
    @Override
    public void guessingNumberGame(int K) {
        super.guessingNumberGame(K);
    }
}

    
    
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose game difficulty level:");
        System.out.println("Easy    Medium    Hard");
        String level = sc.nextLine();
        switch (level) {
            case "Easy":
                Easy easy = new Easy();
				easy.guessingNumberGame(12);
                break;
            
            case "Medium":
				Medium medium = new Medium();
				medium.guessingNumberGame(9);
                break;

            case "Hard":
				Hard hard = new Hard();
				hard.guessingNumberGame(6);
                break;
        }
        sc.close();
    }

}
