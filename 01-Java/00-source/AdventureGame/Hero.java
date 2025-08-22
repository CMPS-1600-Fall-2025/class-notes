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
    
}
