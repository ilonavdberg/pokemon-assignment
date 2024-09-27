public class Pikachu extends Pokemon {
    private String sound = "Pika.. Pika...";
    private String type = "electric";

    public Pikachu() {
        super("Pikachu",13, "ketchup");
        //base stats
        this.setAttack(9);
        this.setDefense(8);
        this.setHpMax(13);
    }

    public void thunderPunch() {
        System.out.println("Thunder Punch");
    }

    public void electroBall() {
        System.out.println("Electro Ball");
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
