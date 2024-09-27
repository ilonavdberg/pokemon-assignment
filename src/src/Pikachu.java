public class Pikachu extends Pokemon {
    String sound = "Pika.. Pika...";

    public Pikachu() {
        super("Pikachu",13, "ketchup");
        //base stats
        this.setAttack(9);
        this.setDefense(8);
        this.setHpMax(13);
    }

    @Override
    public void speaks() {
        System.out.println(sound);
    }

    @Override
    public void rename(String newName) {
        System.out.println("You cannot rename a pikachu!");
    }
}
