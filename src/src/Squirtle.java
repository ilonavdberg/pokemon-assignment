public class Squirtle extends Pokemon {
    String sound = "Squirtle!!!";

    public Squirtle() {
        super("Squirtle",12, "fish");
        //base stats
        this.setAttack(8);
        this.setDefense(11);
        this.setHpMax(10);
    }

    @Override
    public void speaks() {
        System.out.println(sound);
    }
}
