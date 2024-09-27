public class Bulbasaur extends Pokemon {
    private String sound = "Squirtle!!!";

    public Bulbasaur() {
        super("Bulbasaur", PokeType.GRASS, 12, "insect");
        //base stats
        this.setAttack(9);
        this.setDefense(11);
        this.setHpMax(8);
    }

    public void leechSeed() {
        System.out.println("Leech Seed");
    }

    public void leafStorm() {
        System.out.println("Leaf Storm");
    }

    @Override
    public void speaks() {
        System.out.println(sound);
    }
}
