/**
 * Class Hero represents the user protagonist character in our game.
 */
public class Hero {
    private String name;
    private int hp;
    private int damage;

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
    }

    public void takeTurn(Villain villain) {
        // TO-DO implement getHP()
        //System.out.println("%s has %d hp left.", villain.getName(), villian.getHP());
        System.out.println("Do you want to:");
        System.out.println("  1. attack");
        System.out.println("  2. defend");
        // read in user choice
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
