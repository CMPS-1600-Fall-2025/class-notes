abstract public class Character {
    private String name;
    private int hp;
    private int damage;
    // poison state variables
    private int poisonDamage;
    private int poisonTurnCount;


    public Character(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.poisonDamage = 0;
        this.poisonTurnCount = 0;
    }

    /**
     * 
     * @param amount could be positive or negative
     */
    public void modifyHealth(int amount) {
        this.hp += amount;
    }

    public void takeDamage(int damage) {
        modifyHealth(-damage);
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

    abstract public void takeTurn(Character other);

    public void handleCharacterStates(){
        if(this.poisonTurnCount > 0) {
            this.poisonTurnCount--;
            this.modifyHealth(-poisonDamage);
        }
    }

    public void becomePoisoned(int damage) {
        this.poisonTurnCount += 3;
        this.poisonDamage += damage;
    }
}