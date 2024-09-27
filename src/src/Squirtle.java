public class Squirtle extends Pokemon {
    private String sound = "Squirtle!!!";
    private String type = "water";

    public Squirtle() {
        super("Squirtle",12, "fish");
        //base stats
        this.setAttack(8);
        this.setDefense(11);
        this.setHpMax(10);
    }

    public void hydroPump() {
        System.out.println("Hydro Pump");
    }

    public void hydroCanon() {
        System.out.println("Hydro Canon");
    }

    @Override
    public void speaks() {
        System.out.println(sound);
    }
}
