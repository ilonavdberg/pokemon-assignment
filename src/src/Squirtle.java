public class Squirtle extends Pokemon {
    private String sound = "Squirtle!!!";

    public Squirtle() {
        super("Squirtle", PokeType.WATER, 12, "fish");
        //base stats
        this.setAttack(8);
        this.setDefense(12);
        this.setHpMax(10);
        this.setSpeed(9);
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
