public class Charmander extends Pokemon {
    String sound = "Char... Char... Charmander!!";

    public Charmander() {
        // all charmanders will start with 12 max hp and 25 max xp
        super("Charmander",12, 25, 12, 10, "berry");
    }

    @Override
    public void speaks() {
        System.out.println(sound);
    }
}
