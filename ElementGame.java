import java.util.Random;
import java.util.Scanner;

public class ElementGame {
   
    // Define the elements as constants
    private static final int FIRE = 1;
    private static final int WATER = 2;
    private static final int AIR = 3;
    private static final int LAND = 4;

    public static void main(String[] args) {

        // Implement the game menu that allows the player to select their character
        Scanner scanner = new Scanner(System.in);
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      Welcome to the Element Game!       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║          Select your character:         ║");
        System.out.println("║    1. Fire                              ║");
        System.out.println("║    2. Water                             ║");
        System.out.println("║    3. Air                               ║");
        System.out.println("║    4. Land                              ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Select: ");
        int playerElement = scanner.nextInt();

        // Implement the game loop that allows the player to face off against the other three elements
        int[] enemyElements = { FIRE, WATER, AIR, LAND };
        int enemyElement;
        Random random = new Random();
        int playerHealth = 100;
        int enemyHealth = 100;
        int turn = 1;

        while (playerHealth > 0 && enemyElements.length > 0) {

            System.out.println("══════════════════════════════════════════");
            System.out.println("                Match " + turn);
            System.out.println("══════════════════════════════════════════");

            // Choose a random enemy element
            int index = random.nextInt(enemyElements.length);
            enemyElement = enemyElements[index];
            String enemyElementName = getElementName(enemyElement);
            System.out.println("Enemy element: " + enemyElementName);

            // Implement the attack and defense logic for each turn
            System.out.println("══════════════════════════════════════════");
            System.out.println("             Select your move:");
            System.out.println("          1. Attack");
            System.out.println("          2. Defend");
            System.out.println("══════════════════════════════════════════");
            System.out.print("Enter Move: ");
            int playerMove = scanner.nextInt();


        if (playerMove == 1) {
            int damage = calculateDamage(playerElement, enemyElement);
            System.out.println("You deal " + damage + " damage to the enemy");
            enemyHealth = enemyHealth - damage;
        } else {
            System.out.println("You defend against the enemy's attack");
        }

        // The enemy takes their turn
        int enemyMove = random.nextInt(2) + 1;
        if (enemyMove == 1) {
            int damage = calculateDamage(enemyElement, playerElement);
            System.out.println("The enemy deals " + damage + " damage to you");
            playerHealth = playerHealth - damage;
        } else {
            System.out.println("The enemy defends against your attack");
        }

        turn++;
        
    }

    // Implement the game over logic that ends the game when the player either wins or loses
    if (playerHealth > 0) {
        System.out.println("Congratulations! You defeated all the enemies!");
    } else {
        System.out.println("Game over. You lose.");
    }
    scanner.close();
}

private static String getElementName(int element) {
    switch (element) {
        case FIRE:
            return "Fire";
        case WATER:
            return "Water";
        case AIR:
            return "Air";
        case LAND:
            return "Land";
        default:
            return "";
    }
}

    private static int calculateDamage(int attackerElement, int defenderElement) {
        if (attackerElement == FIRE && defenderElement == WATER) {
            return 10;
        } else if (attackerElement == WATER && defenderElement == AIR) {
            return 10;
        } else if (attackerElement == AIR && defenderElement == LAND) {
            return 10;
        } else if (attackerElement == LAND && defenderElement == FIRE) {
            return 10;
        } else {
            return 5;
        }
    }

}
