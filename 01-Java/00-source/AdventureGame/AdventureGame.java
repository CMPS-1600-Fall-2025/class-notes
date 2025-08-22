public class AdventureGame {
    public static void main(String[] args){
        String heroName = "KeyChain";
        int heroHP = 100;
        int heroDamage = 20;

        String villainName = "Door Knob";
        int villainHP = 200;
        int villainDamage = 15;
        enterCombatLoop(heroName, heroHP, heroDamage, villainName, villainHP, villainDamage);
    }

    public static void enterCombatLoop(String heroName, int heroHP, int heroDamage, String villainName, int villainHP, int villainDamage) {
        while(true) {
            // hero attack the villian
            System.out.printf("%s attacks %s for %d damage.\n", heroName, villainName, heroDamage);
            villainHP -= heroDamage;
            System.out.printf("   %s has %d HP left\n\n", villainName, villainHP);

            if(villainHP <= 0) {
                System.out.printf("You won! Congrats!!!!!\n");
                break;
            }

            System.out.printf("%s attacks %s for %d damage.\n", villainName, heroName, villainDamage);
            heroHP -= villainDamage;
            System.out.printf("   %s has %d HP left\n\n", heroName, heroHP);

            if(heroHP <= 0) {
                System.out.printf("You lose! How sad :-(\n");
                break;
            }
        }
    }
}
