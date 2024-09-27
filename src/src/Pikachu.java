public class Pikachu extends Pokemon {
    String sound = "Pika.. Pika...";

    public Pikachu() {
        // all pikachus will start with 13 max hp and 20 max xp
        super("Pikachu",13, 25, 10, 11, "ketchup");
    }

    @Override
    public void speaks() {
        System.out.println(sound);
    }
}
