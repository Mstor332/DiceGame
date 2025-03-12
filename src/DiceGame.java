//Opgave Black Jack Die game, lavet af Marco:)
import java.util.Scanner;
import java.util.Random;

public class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int spillerScore = 0;
        int computerScore = 0;

        System.out.println("Velkommen til mit Black Jack Dice spil!");
        System.out.println("Vil du gerne starte spillet og slå med terningerne? ja/nej");
        String valg = scanner.nextLine();
/*Jeg spørg den først om jeg skal kaste terningen istedet for at give en score med det
samme, da jeg syntes det føles bedre.
 */

        while (true) {
            //Spillers kode
            int spillerRoll = rollDice();
            spillerScore += spillerRoll;

            //Computerens kode
            int computerRoll = rollDice();
            computerScore += computerRoll;

            System.out.println("Du har slået: " + spillerRoll);
            System.out.println("Din nuværende score er: " + spillerScore);

            if (spillerScore > 21) {
                System.out.println("Du tællede dine terninger forkert! Du gik over 21! Computeren vinder!");
                return;
            }

            System.out.println("Vil du slå igen? ja/nej");
            valg = scanner.nextLine();

            if (valg.equalsIgnoreCase("nej")) {
                System.out.println("Du stopper på disse tal: " + spillerScore);
                System.out.println("Computeren fik: " + computerScore);
                break;
            }
        }
        while(computerScore < 16){
            computerScore += rollDice();
        }

        System.out.println("Du har: " + spillerScore + ", Computeren har: " + computerScore);

        if (computerScore > 21) {
            System.out.println("Computeren gik over 21, du vinder!");
        } else if (spillerScore > computerScore) {
            System.out.println("DU HAR VUNDET YUBII Computerens score: " + computerScore);
        } else {
            System.out.println("Computeren vinder!");
        }
    }

    public static int rollDice() {
        Random random = new Random();
    //Jeg har gjort 2 terninger om til 1 ved at allerede sammesætte dem.
        return random.nextInt(2, 13);

    }
}
