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

    public void takeTurn(Villain villain) {
        // TO-DO implement getHP()
        //System.out.println("%s has %d hp left.", villain.getName(), villian.getHP());
        System.out.println("Do you want to:");
        System.out.println("  1. attack");
        System.out.println("  2. defend");
        System.out.print("Enter your choice: ");
        System.out.flush();
        int choice = in.nextInt();
        
        if(choice == 1) {
            this.attack(villain);
        }
        else {
            System.out.println("You defend against the threatening door knob!");
        }
        // read in user choice
        
        //in.next();
        
        System.out.printf("user choice: %d\n",choice);
        //in.close();
    }
    
}
