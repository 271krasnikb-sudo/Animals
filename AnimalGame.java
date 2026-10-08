import ch05.collections.ArrayCollection;
import java.util.Scanner;
import java.io.IOException;

public class AnimalGame{
    public static void main(String[] args) throws IOException
    {
        ArrayCollection<String> animals = new ArrayCollection<>(600);
        System.out.println("Welcome to the Animal Game!");
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Scanner sc = new Scanner(new java.io.File("Animals.txt"));
        while (sc.hasNextLine())
        {
            String animal = sc.nextLine().trim().toLowerCase();
            animals.add(animal);
        }

        sc.close();

        int randomIndex = (int) (Math.random() * characters.length());
        char target = characters.charAt(randomIndex);

        System.out.println("Enter an animal starting with " + target);
        System.out.println("The game ends when you make a mistake");

        Scanner userSc = new Scanner(System.in);
        ArrayCollection<String> used = new ArrayCollection<>();
        int count = 0;
        boolean gameOver = false;
        boolean playAgain = true;
        while(playAgain) {
            while (!gameOver){
                System.out.println("ANIMAL: ");
                String guess = userSc.nextLine().trim().toLowerCase();
                if(guess.charAt(0) != target || guess.length() == 0){
                    gameOver = true;
                    System.out.println("Game over! You entered an animal that does not start with " + target + " or left it empty.");
                    System.out.println("You guessed " + count + " animals before the game ended.");
                } else if(!animals.contains(guess)){
                    gameOver = true;
                    System.out.println("Game over! " + guess + " is not in the list of animals.");
                    System.out.println("You guessed " + count + " animals before the game ended.");
                } else if(used.contains(guess)){
                    gameOver = true;
                    System.out.println("Game over! You already guessed " + guess);
                    System.out.println("You guessed " + count + " animals before the game ended.");
                } else {
                    used.add(guess);
                    count++;
                    System.out.println("Correct! You have guessed " + count + " animals.");
                }
                }

            System.out.println("Do you want to play again? (yes/no)");
            String playAgainResponse = userSc.nextLine().trim().toLowerCase();
            playAgain = playAgainResponse.equals("yes") || playAgainResponse.equals("y")|| playAgainResponse.equals("yeah") || playAgainResponse.equals("yep");
            }
        }

}