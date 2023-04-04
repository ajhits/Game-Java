// Element Quest Game
// ********************* Jolo Game and Regulations ********************* //
/* 


----- Jolo Goals
    The goal of this game is to increase your level as much as possible.
---- Jolo Rules
    1. Maintain your lifepoints at 100; if you lose all of your lifepoints, the game is over.
    2. If you win, you will gain +5 life points if your opponent has the same element type as you.
    
       NOTE: the maximum number of life points you can have is 100. If your life points are already 
       at 100 and you receive an additional 5 life points, the additional 5 points will not be added 
       to your total.
---- Jolo rules damage
        Attack <> Attack = damage 5
        Attack <> Defend = damage 10 (vice versa)
        Defend <> Defend = damage 10 (vice versa)
       

*/



package game;

import java.util.Random;
import java.util.Scanner;


public class ElementGame {
   
    // Define the elements as constants
    private static final int FIRE = 1;
    private static final int WATER = 2;
    private static final int AIR = 3;
    private static final int LAND = 4;

    // clear text
    public static void clearConsole() {
        // Use ANSI escape codes to clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // get elemental type
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

    // fight result
    private static int calculateDamage(int attackerElement, int defenderElement) {
        
        // attack <> attack = damage 5
        if (attackerElement == 0 & defenderElement== 0){
            return 5;

        // attack <> defend = damage 5
        }else if (attackerElement == 0 & defenderElement== 1){
            return 10;

        // defend <> attack = damage 5
        }else if(attackerElement == 1 & defenderElement== 0){
            return 10;

        // defend <> defend = damage 0
        }else{
            return 0;
        }

    }

    // get the player status
    private void playerStats(String playerElementType,String playerName, String playerHealth){
        System.out.println("Element type = " + playerElementType);
        System.out.println(playerName + "'s Health = " + playerHealth);

    }

    // main function
    public static void main(String[] args) {

        clearConsole();

        // Implement the game menu that allows the player to select their character
        Scanner scanner = new Scanner(System.in);
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║      Welcome to the Element Quest!      ║");
        System.out.println("╠═════════════════════════════════════════╣");
        System.out.println("║          Select your character:         ║");
        System.out.println("║    1. Fire                              ║");
        System.out.println("║    2. Water                             ║");
        System.out.println("║    3. Air                               ║");
        System.out.println("║    4. Land                              ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.print("Select: ");
        int playerElement = scanner.nextInt();
        
        System.out.print("PlayerName: ");
        String playerName = scanner.next();

        // Consume the newline character left in the buffer
        scanner.nextLine();

        // to clear text
        clearConsole();

        // Introductory text
        System.out.println("══════════════════════════════════════════");
        System.out.println(" Hello " + playerName);
        System.out.println(" Please be ready ");
        System.out.println("══════════════════════════════════════════");

        System.out.println(" press enter to continue.......... ");

        // Consume the newline character left in the buffer
        scanner.skip(".*");
        scanner.nextLine();

        // Implement the game loop that allows the player to face off against the other three elements
        int[] Elements = { FIRE, WATER, AIR, LAND };
        int enemyElement;
        int playerHealth = 100; //player healths
        int turn = 1;
        Random random = new Random();

        while (playerHealth > 0 && Elements.length > 0) {

// NOTE: array always Start at 0!!!!
// NOTE: if function was static you can call them by its 'NameOfFunction()''
//       if function was not static you call them by 'new Classname.NameOfFunction()''

            // to clear text
            clearConsole();
            
            // level turn
            System.out.println("══════════════════════════════════════════");
            System.out.println("                Level " + turn);
            System.out.println("══════════════════════════════════════════");

            // Choose a random enemy element
            int index = random.nextInt(Elements.length); // get the Elements size via Lenght function
            enemyElement = Elements[index]; // access Elements via index number 
            String enemyElementName = getElementName(enemyElement); // get Element name via getElementName function
            System.out.println("Enemy element: " + enemyElementName);

            // Implement the attack and defense logic for each turn
            System.out.println("══════════════════════════════════════════");
            System.out.println("            Select your move:");
            System.out.println("                1. Attack");
            System.out.println("                2. Defend");
            System.out.println("══════════════════════════════════════════");

            // ========= Player Stats ========= //
            
            // get an elemental type
            int playerElementType = Elements[playerElement - 1];

            // String.valueOf() = convert Int to String
            new ElementGame().playerStats(
                getElementName(playerElementType), // get character element type
                playerName, //get the player Name
                String.valueOf(playerHealth) // get the player Health
            );

            // ================= //
            System.out.println();
            System.out.print("Enter Move: ");

            // you take the turn
            int playerMove = scanner.nextInt();

            // Consume the newline character left in the buffer
            scanner.nextLine();

            String[] attackMove = {"Attack", "Defend"};

            // The enemy takes their turn
            int enemyMove = random.nextInt(2);



            // ======================= FIGHTHING ======================= //
            clearConsole();

            playerMove -= 1;

            System.out.println();
            System.out.println("══════════════════════════════════════════");
            System.out.println( "                figthing!");
            System.out.println("══════════════════════════════════════════");
            System.out.println("═════════ Your choose to " + attackMove[playerMove] + " ══════════");
            System.out.println("═════════ Enemy choose to " + attackMove[enemyMove] + " ═════════");
            System.out.println("══════════════════════════════════════════");
            System.out.println("══════════════════════════════════════════");

            // fighting result
            Boolean result = random.nextBoolean();
        
            // damage 
            int damage = calculateDamage(playerMove, enemyMove);

            //  wins else enemy won
            if (result) {
                // if player win

                System.out.println("════════ Congratulations you win! ════════\n\n");
                System.out.println("You deal " + damage + " damage to the enemy\n");

                // if playerElementType is equal to enemyElement type
                if (getElementName(playerElementType) == enemyElementName){

                    // player get +5 health points and player health max 100 points only
                    if (playerHealth < 100){
                        playerHealth += 5;
                        if (playerHealth >= 100){
                            playerHealth = 100;
                        }
                    }

                }

            }else{
                // if enemy won
            
                System.out.println("════════════ Enemy win! ════════════\n\n");
                System.out.println("The enemy deals " + damage + " damage to you\n");
                playerHealth -= damage;
            }
            
            // String.valueOf() = convert Int to String
            new ElementGame().playerStats(
                getElementName(playerElementType), // get character element type
                playerName, //get the player Name
                String.valueOf(playerHealth) // get the player Health
            );

            
            System.out.println("\n\n press enter to continue......");
            scanner.skip(".*");
            scanner.nextLine();
            turn++;
        
        }


        clearConsole();

        System.out.println("Game over. You lose.");

        System.out.print("Wanna play again ? [Y/N]: ");
        String again = scanner.next(); // get input

// NOTE: when comparing to String it is necessary to use '.equals' than '==' if fail to use the condition wont run
        if (again.equals("Y") || again.equals("y")){
            main(args);
        }

        scanner.close();
    }

}