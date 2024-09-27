public class Main {
    public static void main(String[] args) {
        Charmander myCharmander = new Charmander();
        Pikachu myPikachu = new Pikachu();

        myCharmander.getStats();
        myPikachu.getStats();

        Pokemon.battle(myCharmander, myPikachu);

        myCharmander.eats("berry");
        myPikachu.eats("ketchup");

        Pokemon.battle(myCharmander, myPikachu);

        myCharmander.eats("berry");
        myPikachu.eats("ketchup");

        Pokemon.battle(myCharmander, myPikachu);
    }
}