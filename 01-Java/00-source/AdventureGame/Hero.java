import java.util.Scanner;
/**
 * Class Hero represents the user protagonist character in our game.
 */
public class Hero {
    private String name;
    private int hp;
    private int damage;
    private Scanner in;

    /**
     * 
     * @param name the name for this hero
     * @param hp the number of starting hit points for this hero
     * @param damage the base amount of damage this hero deals in an attack
     */
    public Hero(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
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

    public void attack(Villain villain) {
        System.out.printf("%s attacks %s for %d damage.\n", 
                            this.name, 
                            villain.getName(), 
                            this.damage);
        villain.takeDamage(this.damage);
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        // hp can not be negative
        if(this.hp < 0) {
            this.hp = 0;
        }
        System.out.printf("   %s has %d HP left\n\n", this.name, this.hp);
    }

    public String getName(){
        return this.name;
    }

    public Boolean isAlive() {
        if(this.hp > 0) {
            return true;
        }
        return false;
    }
    
}
