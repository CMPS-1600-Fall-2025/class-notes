/**
 * Class Villain represents the user protagonist character in our game.
 */
public class Villain extends Character{

    /**
     * 
     * @param name the name for this villain
     * @param hp the number of starting hit points for this villain
     * @param damage the base amount of damage this villain deals in an attack
     */
    public Villain(String name, int hp, int damage) {
        super(name, hp, damage);
    }
    
    // This attack overrides the attack we inherit from Character.
    // That is, when a villain attacks, this method will be used instead of the
    // version written in Character.
    @Override
    public void takeTurn(Character other) {
        this.handleCharacterStates();
        // choice 1 = attack
        // choice 2 = defend
        int choice = AdventureGame.random.nextInt(2);

        if (choice == 1) {
            attack(other);
        }
        else {
            System.out.printf("%s defends himself.\n", this.getName());
        }
    }
}
