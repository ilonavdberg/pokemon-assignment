public class Charmander extends Pokemon {
    String sound = "Char... Char... Charmander!!";

    public Charmander() {
        super("Charmander",12, "berry");
        //base stats
        this.setAttack(10);
        this.setDefense(8);
        this.setHpMax(10);
    }

    @Override
    public void speaks() {
        System.out.println(sound);
    }
}
