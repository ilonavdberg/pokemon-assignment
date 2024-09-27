public abstract class Pokemon {
    private final PokeType type;
    private String name;
    private int level;
    private int hpMax;
    private int hp;
    private int xpMax;
    private int xp;
    private int attack;
    private int defense;
    private String food;

    public Pokemon(String name, PokeType type, int xpMax, String food) {
        this.name = name;
        this.type = type;
        this.xpMax = xpMax;
        this.food = food;
        this.level = 1;
        this.xp = 0;
    }

    public void getStats() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp + " / " + hpMax);
        System.out.println("XP: " + xp + " / " + xpMax);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("----------");
    }

    public void rename(String newName) {
        this.name = newName;
    }

    public static void battle(Pokemon pokemon1, Pokemon pokemon2) {
        // Fight
        while (pokemon1.hp > 0 && pokemon2.hp > 0) {
            pokemon1.fight(pokemon2);
            pokemon2.fight(pokemon1);
        }

        // Increase XP
        pokemon1.increaseXP(pokemon2);
        pokemon2.increaseXP(pokemon1);
    }

    private void fight(Pokemon other) {
        // Calculate damage
        int damage = (int) ((Math.max(this.attack - (other.defense / 2), 0) + this.level) * type.getDamageMultiplier(other.type));
        other.hp = Math.max(other.hp - damage, 0);
    }

    private void increaseXP(Pokemon opponent) {
        int xpIncrease;
        // if won
        if (this.hp > 0) {
            xpIncrease = (Math.max(opponent.level - this.level, 0) + this.level) * 15;
        } else {
            xpIncrease = this.level * 10;
        }

        while (xpIncrease > 0) {
            int xpToNextLevel = this.xpMax - this.xp;
            if (xpToNextLevel > xpIncrease) {
                this.xp += xpIncrease;
                break;
            } else {
                xpIncrease -= xpToNextLevel;
                levelUp();
            }
        }

        getStats();
    }

    private void levelUp() {
        System.out.println(this.name + ": Level up!");
        this.level++;
        this.xp = 0;
        this.attack += statIncrease();
        this.defense += statIncrease();

        this.hpMax = (int) (this.hpMax * 1.2);
        this.xpMax = (int) (this.xpMax * 1.2);
    }

    private int statIncrease() {
        // 60% chance to increase with 1
        // 30% chance to increase with 2
        // 10% chance to increase with 3
        Integer[]  increases = {1, 1, 1, 1, 1, 1, 2, 2, 2, 3};
        int index = (int) (Math.random() * increases.length);
        return increases[index];
    }

    public void eats(String food) {
        if (this.food.equals(food.toLowerCase())) {
            speaks();
            heal();
        } else {
            System.out.println(name + " does not want to eat this... ");
        }
    }

    private void heal() {
        this.hp = hpMax;
    }

    public abstract void speaks();

    public void setAttack(int attack) {
        this.attack = attack + statIncrease();
    }

    public void setDefense(int defense) {
        this.defense = defense + statIncrease();
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax + statIncrease();
        this.hp = this.hpMax;
    }
}
