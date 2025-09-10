import java.util.Scanner;
/**
 * Class Hero represents the user protagonist character in our game.
 */
public class Hero extends Character {
    private Scanner in;

    /**
     * 
     * @param name the name for this hero
     * @param hp the number of starting hit points for this hero
     * @param damage the base amount of damage this hero deals in an attack
     */
    public Hero(String name, int hp, int damage) {
        // if we don't call on superclass constructor java will call on
        // default constructor:
        // super();
        super(name, hp, damage);
        in = new Scanner(System.in);
    }

    @Override
    public void takeTurn(Character villain) {
        handleCharacterStates();
        // in case poison defeats them at top of their turn
        if(this.getHP() <= 0) {
            return;
        }
        // TO-DO implement getHP()
        //System.out.println("%s has %d hp left.", villain.getName(), villian.getHP());
        System.out.println("Do you want to:");
        System.out.println("  1. attack");
        System.out.println("  2. defend");
        System.out.println("  3. use potion");
        System.out.print("Enter your choice: ");
        System.out.flush();
        int choice = in.nextInt();
        
        if(choice == 1) {
            this.attack(villain);
        }
        else if (choice == 2){
            System.out.println("You defend against the threatening door knob!");
        }
        else if (choice == 3) {
            // use a potion
            usePotion(villain);
        }
        // read in user choice
        
        //in.next();
        //in.close();
    }

    private void usePotion(Character other) {
        System.out.println("  What potion do you want to use:");
        System.out.println("    1. health");
        System.out.println("    2. poison");
        System.out.println("    3. strength");
        System.out.print("Enter your choice: ");
        System.out.flush();
        int choice = in.nextInt();
        if(choice == 1) {
            // health potion
            HealthPotion p = new HealthPotion(15);
            p.takePotion(this);
        } else if (choice == 2){
            Potion p = new PoisonPotion(5);
            p.takePotion(other);
        } else if (choice == 3){
            // strength
        }
    }
    
}
