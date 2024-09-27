public enum PokeType {
    FIRE (1, 0.5, 2, 1),
    WATER (2, 1, 0.5, 0.5),
    GRASS (0.5, 2, 1, 1),
    ELECTRIC (1, 2, 1, 1);

    private double[] damageTable = new double[4];

    PokeType(double fireDamageFactor, double waterDamageFactor, double grassDamageFactor, double electricDamageFactor) {
        damageTable[0] = fireDamageFactor;
        damageTable[1] = waterDamageFactor;
        damageTable[2] = grassDamageFactor;
        damageTable[3] = electricDamageFactor;
    }

    public double getDamageMultiplier(PokeType other) {
        return damageTable[other.ordinal()];
    }
}



// source: https://blog.terresquall.com/2022/09/enumerations-explained-using-pokemon-as-an-example/