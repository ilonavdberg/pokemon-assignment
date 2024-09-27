public class Main {
    public static void main(String[] args) {
        Charmander myCharmander = new Charmander();
        Pikachu myPikachu = new Pikachu();
        Squirtle mySquirtle = new Squirtle();
        Bulbasaur myBulbasaur = new Bulbasaur();

        myCharmander.getStats();
        myPikachu.getStats();
        mySquirtle.getStats();
        myBulbasaur.getStats();

        mySquirtle.rename("Bubbles");
        myPikachu.rename("Sparky");

        Pokemon.battle(myCharmander, myPikachu);
        Pokemon.battle(mySquirtle, myBulbasaur);

        myCharmander.eats("berry");
        myPikachu.eats("berry");
        myPikachu.eats("ketchup");
        mySquirtle.eats("fish");
        myBulbasaur.eats("insect");

        Pokemon.battle(myCharmander, mySquirtle);
        Pokemon.battle(myPikachu, myBulbasaur);
    }
}