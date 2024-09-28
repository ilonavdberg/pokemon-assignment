public class PokeBattle {
    private static Pokemon attacker;
    private static Pokemon defender;

    public PokeBattle(Pokemon pokemon1, Pokemon pokemon2) {
        prepareToFight(pokemon1, pokemon2);
        fight();
        pokemon1.increaseXP(pokemon2);
        pokemon2.increaseXP(pokemon1);
    }

    public void prepareToFight(Pokemon pokemon1, Pokemon pokemon2) {
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
}
