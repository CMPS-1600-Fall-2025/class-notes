/**
 * Class Villain represents the user protagonist character in our game.
 */
public class Villain {
    private String name;
    private int hp;
    private int damage;

    /**
     * 
     * @param name the name for this villain
     * @param hp the number of starting hit points for this villain
     * @param damage the base amount of damage this villain deals in an attack
     */
    public Villain(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
    
    public void attack(Hero hero) {
        System.out.printf("%s attacks %s for %d damage.\n", 
                            this.name, 
                            hero.getName(), 
                            this.damage);
         hero.takeDamage(this.damage);
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
