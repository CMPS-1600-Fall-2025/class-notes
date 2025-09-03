import java.util.Random;

public class Character {
    protected String name;
    protected int hp;
    protected int damage;
    protected Random random;

    public Character(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;

        this.random = new Random();
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

    public int getHP() {
        return this.hp;
    }

    public int getDamage() {
        return this.damage;
    }

    public Boolean isAlive() {
        if(this.hp > 0) {
            return true;
        }
        return false;
    }

    public void attack(Character other) {
        System.out.printf("%s attacks %s for %d damage.\n", 
                            this.getName(), 
                            other.getName(), 
                            this.getDamage());
        other.takeDamage(this.getDamage());
    }
}