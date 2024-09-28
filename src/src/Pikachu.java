public class Pikachu extends Pokemon {
    private String sound = "Pika.. Pika...";

    public Pikachu() {
        super("Pikachu", PokeType.ELECTRIC, 13, "ketchup");
        //base stats for each Pikachu
        this.setAttack(9);
        this.setDefense(8);
        this.setHpMax(11);
        this.setSpeed(11);
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
}
