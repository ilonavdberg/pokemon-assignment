public class PokeBattle {
    private static Pokemon attacker;
    private static Pokemon defender;

    public PokeBattle(Pokemon pokemon1, Pokemon pokemon2) {
        prepareToFight(pokemon1, pokemon2);
        fight();
        pokemon1.increaseXP(calculateXp(pokemon1, pokemon2));
        pokemon2.increaseXP(calculateXp(pokemon2, pokemon1));
        pokemon1.showStats();
        pokemon2.showStats();
    }

    public void prepareToFight(Pokemon pokemon1, Pokemon pokemon2) {
        if (pokemon1.getHp() == 0) {
            System.out.println(pokemon1.getName() + " is not able to fight...");
            return;
        }
        if (pokemon2.getHp() == 0) {
            System.out.println(pokemon2.getName() + " is not able to fight...");
            return;
        }

        if (pokemon1.getSpeed() > pokemon2.getSpeed()) {
            attacker = pokemon1;
            defender = pokemon2;
        } else if (pokemon1.getSpeed() < pokemon2.getSpeed()) {
            attacker = pokemon2;
            defender = pokemon1;
        } else {
            Pokemon[] draw = {pokemon1, pokemon2};
            int pick = (int) (Math.random() * 2);
            attacker = draw[pick];
            defender = draw[Math.abs(pick - 1)]; //will always be the other pokemon
        }
    }

    private void fight() {
        while (attacker.getHp() > 0) {
            inflictDamage(calculateDamage());
            prepareNextRound();
        }
    }

    private int calculateDamage() {
        int damage = (int) ((Math.max(attacker.getAttack() - (defender.getDefense() / 2), 0) + attacker.getLevel())
                * attacker.getType().getDamageMultiplier(defender.getType()));
        System.out.println(attacker + " inflicted " + damage + " damage on " + defender);
        return damage;
    }

    private void inflictDamage(int damage) {
        defender.reduceHp(damage);
    }

    private void prepareNextRound() {
        Pokemon temp = attacker;
        attacker = defender;
        defender = temp;
    }

    private int calculateXp(Pokemon pokemon, Pokemon opponent) {
        int xpIncrease;
        // if won
        if (pokemon.getHp() > 0) {
            xpIncrease = (Math.max(opponent.getLevel() - pokemon.getLevel(), 0) + pokemon.getLevel()) * 15;
        } else {
            xpIncrease = pokemon.getLevel() * 10;
        }
        return xpIncrease;
    }
}
