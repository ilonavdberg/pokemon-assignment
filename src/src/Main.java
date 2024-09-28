public class Main {
    public static void main(String[] args) {
        Charmander myCharmander = new Charmander();
        Pikachu myPikachu = new Pikachu();
        Squirtle mySquirtle = new Squirtle();
        Bulbasaur myBulbasaur = new Bulbasaur();

        Pokemon[] myPokemonParty = new Pokemon[4];
        myPokemonParty[0] = myCharmander;
        myPokemonParty[1] = myPikachu;
        myPokemonParty[2] = mySquirtle;
        myPokemonParty[3] = myBulbasaur;

        for (Pokemon pokemon : myPokemonParty) {
            pokemon.showStats();
        }

        new PokeBattle(myBulbasaur, mySquirtle);
        new PokeBattle(myPikachu, myCharmander);

        for (Pokemon pokemon : myPokemonParty) {
            pokemon.showStats();
        }

        for (Pokemon pokemon : myPokemonParty) {
            pokemon.eats(pokemon.getFood());
        }

        new PokeBattle(myPikachu, mySquirtle);
        new PokeBattle(myBulbasaur, myCharmander);

        for (Pokemon pokemon : myPokemonParty) {
            pokemon.showStats();
        }

    }
}