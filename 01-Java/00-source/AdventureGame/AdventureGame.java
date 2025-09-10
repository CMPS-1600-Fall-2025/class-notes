import java.util.Random;

public class AdventureGame {
    public static Random random = new Random();

    public static void main(String[] args){
        Character hero = new Hero("KeyChain", 100, 20);
        Character villain = new Villain("Door Knob", 200, 15);

        enterCombatLoop(hero, villain);
    }

    public static void enterCombatLoop(Character hero, Character villain) {
        System.out.printf("You the great %s are in a fight with %s!\n", hero.getName(), villain.getName());
        System.out.printf("Evil %s stole $500 from you! You are fuming because you can't afford a PS5 now!\n", villain.getName());
        System.out.printf("  You have %d hp, and you deal %d attack damage\n", hero.getHP(), hero.getDamage());
        System.out.printf("  %s has %d hp, and deals %d attack damage.\n", villain.getName(), villain.getHP(), villain.getDamage());

        while(true) {
            // hero attack the villian
            
            hero.takeTurn(villain);
            if(!villain.isAlive()) {
                System.out.printf("You won! Congrats!!!!!\n");
                break;
            }

            villain.takeTurn(hero);
            if(!hero.isAlive()) {
                System.out.printf("You lose! How sad :-(\n");
                break;
            }
        }
    }
}
