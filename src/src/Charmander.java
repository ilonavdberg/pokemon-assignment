public class Charmander extends Pokemon {
    private String sound = "Char... Char... Charmander!!";
    private String type = "fire";

    public Charmander() {
        super("Charmander",12, "berry");
        //base stats
        this.setAttack(10);
        this.setDefense(8);
        this.setHpMax(10);
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
