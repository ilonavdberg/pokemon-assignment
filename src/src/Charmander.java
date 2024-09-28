public class Charmander extends Pokemon {
    private String sound = "Char... Char... Charmander!!";

    public Charmander() {
        super("Charmander", PokeType.FIRE, 12, "berry");
        //base stats
        this.setAttack(10);
        this.setDefense(8);
        this.setHpMax(10);
        this.setSpeed(10);
    }

    public void inferno() {
        System.out.println("Inferno");
    }

    public void pyroBall() {
        System.out.println("Pyro Ball");
    }

    @Override
    public void speaks() {
        System.out.println(sound);
    }
}
