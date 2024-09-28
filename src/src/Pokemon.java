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
    private int speed;
    private String food;

    public Pokemon(String name, PokeType type, int xpMax, String food) {
        this.name = name;
        this.type = type;
        this.xpMax = xpMax;
        this.food = food;
        this.level = 1;
        this.xp = 0;
    }

    public void showStats() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp + " / " + hpMax);
        System.out.println("XP: " + xp + " / " + xpMax);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("----------");
    }

    protected void increaseXP(Pokemon opponent) {
        int xpIncrease;
        // if won
        if (this.hp > 0) {
            xpIncrease = (Math.max(opponent.level - this.level, 0) + this.level) * 15;
        } else {
            xpIncrease = this.level * 10;
        }
        System.out.println(this.name + " gained " + xpIncrease + "XP");

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

        showStats();
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

    private int statIncrease() {
        // 60% chance to increase with 1
        // 30% chance to increase with 2
        // 10% chance to increase with 3
        Integer[]  increases = {1, 1, 1, 1, 1, 1, 2, 2, 2, 3};
        int index = (int) (Math.random() * increases.length);
        return increases[index];
    }

    public void setAttack(int attack) {
        this.attack = attack + statIncrease();
    }

    public void setDefense(int defense) {
        this.defense = defense + statIncrease();
    }

    public void setSpeed(int speed) {
        this.speed = speed + statIncrease();
    }

    public void reduceHp(int reduction) {
        this.hp -= reduction;
        if (this.hp <= 0) { this.hp = 0; }
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax + statIncrease();
        this.hp = this.hpMax;
    }

    public String getName() {
        return name;
    }

    public PokeType getType() {
        return this.type;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getLevel() {
        return this.level;
    }

    public String getFood() {
        return this.food;
    }

    @Override
    public String toString() {
        return name;
    }
}
