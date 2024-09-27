

public abstract class Pokemon {
    private String name;
    private int level;
    private int hpMax;
    private int hp;
    private int xpMax;
    private int attack;
    private int defense;
    private int xp;
    private String food;

    public Pokemon(String name, int hpMax, int xpMax, int attack, int defence, String food) {
        this.name = name;
        this.hpMax = hpMax;
        this.xpMax = xpMax;
        this.hp = hpMax;
        this.attack = attack;
        this.defense = defence;
        this.food = food;
        this.level = 1;
        this.xp = 0;
    }

    public void getStats() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp + " / " + hpMax);
        System.out.println("XP: " + xp + " / " + xpMax);
        System.out.println("----------");
    }

    public static void battle(Pokemon pokemon1, Pokemon pokemon2) {
        // Fight
        while (pokemon1.hp > 0 && pokemon2.hp > 0) {
            pokemon1.fight(pokemon2);
            pokemon2.fight(pokemon1);
        }

        System.out.println("Fight ended...");

        // Increase XP
        pokemon1.increaseXP(pokemon2);
        pokemon2.increaseXP(pokemon1);
    }

    private void fight(Pokemon other) {
        // Calculate damage
        int damage = this.attack - other.defense + this.level;
        other.hp = Math.max(other.hp - damage, 0);
    }

    private void increaseXP(Pokemon opponent) {
        int xp;
        // if won
        if (this.hp > 0) {
            xp = (Math.max(opponent.level - this.level, 0) + this.level) * 15;
        } else {
            xp = this.level * 10;
        }

        System.out.println("XP gained is: " + xp);

        if ((this.xpMax - this.xp) > xp) {
            this.xp += xp;
        } else {
            this.xp = xp - (this.xpMax - this.xp);
            levelUp();

        }
        getStats();
    }

    private void levelUp() {
        System.out.println("Level up!");
        this.level++;
        this.attack++;
        this.defense++;

        this.hpMax = (int) (this.hpMax * 1.2);
        this.xpMax = (int) (this.xpMax * 1.2);
    }

    public void eats(String food) {
        if (this.food.equals(food.toLowerCase())) {
            System.out.println("Yummmy!");
            heal();
        } else {
            System.out.println("Blegh...");
        }
    }

    private void heal() {
        this.hp = hpMax;
    }

    public abstract void speaks();
}
