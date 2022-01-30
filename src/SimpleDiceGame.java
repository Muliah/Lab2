import java.util.ArrayList;
import java.util.Scanner;

public class SimpleDiceGame {
    static Scanner input = new Scanner(System.in);  //Man kan komma åt scanner från alla funktioner,så länge fuktionerna är inuti klassen

    public static void main(String[] args) {
        printHeader();
        ArrayList<Player> a = initialize();
        takeTurn(a);
        getWinners(a);
    }

    public static int numberOfRounds;
    public static int dices;
    public static int sides;

    public static void printHeader() {
        System.out.println("Welcome to Dice Game!");
    }


    private static ArrayList<Player> initialize() {
        ArrayList<Player> playerList = new ArrayList<>();
        //tar emot andvändariput
        System.out.println("How many dice do you want ? ");
        dices = input.nextInt();

        System.out.println("How many sides should the dice have: ");
        sides = input.nextInt();

        input.nextLine();

        System.out.println("Do you want to create players? Y / N + Enter ");
        String answer = input.nextLine();


        while (answer.equalsIgnoreCase("j"))                      // (equalsIgnoreCase) = ignorerar fallet medan två strängar jämförs
                                                                              //lägger till spelare
        {
            System.out.println("Enter player name:");
            String playerName = input.nextLine();
            Player player = new Player(playerName, 0);

            for (int i = 0; i < dices; i++) {
                Die di = new Die(sides);
                player.addDie(di);
            }
            playerList.add(player);

            System.out.println("Do you want to create players? Y / N + Enter ");           //frågar igen om man vill tillägga flera spelare
            answer = input.nextLine();
        }


        takeTurn(playerList);

        return playerList;

    }

    private static void takeTurn(ArrayList<Player> players) {

        while (numberOfRounds < 5)                                                 //loop för att köra fem omgångar
        {
            for (Player p : players) {
                System.out.println(p.getName() + " " + "It's your turn to guess the total amount of your dice: ");
                int guessInput = input.nextInt();
                System.out.println("You're guessing: " + guessInput);
                System.out.println("Press ENTER to roll the dice!");
                input.nextLine();
                p.rollDice();
                input.nextLine();
                System.out.println("Dice Rolled: " + p.getDieValue());

                if (guessInput == p.getDieValue()) {
                    System.out.println("You guessed right! 1 point is awarded!");
                    p.increaseScore();
                    System.out.println(p.getName() + " " + "Your points: " + p.getScore());
                } else {
                    System.out.println("Sorry, you guessed wrong ..");
                }
                input.nextLine();

            }
            numberOfRounds++;
        }
        getWinners(players);
    }


    private static ArrayList<Player> getWinners(ArrayList<Player> players) {

        Player player = players.stream().max((p1, p2) -> Integer.compare(p1.getScore(), p2.getScore())).get();  // det är filter som ska jämnföra spelarnas poäng

        if (player.getScore() == 0) {
            System.out.println("No winner ..");
        } else
            System.out.println("Winner: " + player.getName() + " " + "with" + " " + player.getScore() + " " + "point");

        return players;
    }
}







