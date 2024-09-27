public class Bulbasaur extends Pokemon {
    String sound = "Squirtle!!!";

    public Bulbasaur() {
        super("Bulbasaur",12, "insect");
        //base stats
        this.setAttack(9);
        this.setDefense(11);
        this.setHpMax(8);
    }

    @Override
    public void speaks() {
        System.out.println(sound);
    }
}
