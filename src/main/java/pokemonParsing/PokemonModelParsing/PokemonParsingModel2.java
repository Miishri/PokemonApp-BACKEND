package pokemonParsing.PokemonModelParsing;

public class PokemonParsingModel2 {

    private String name;

    private String TypeOne;
    private String TypeTwo;

    private long HP;
    private long Attack;
    private long Defense;
    private long SAttack;
    private long SDefense;
    private long Speed;

    public PokemonParsingModel2(){}

    public PokemonParsingModel2(String name, String typeOne, String typeTwo, long HP, long attack, long defense, long SAttack, long SDefense, long speed) {
        this.name = name;
        this.TypeOne = typeOne;
        this.TypeTwo = typeTwo;
        this.HP = HP;
        Attack = attack;
        Defense = defense;
        this.SAttack = SAttack;
        this.SDefense = SDefense;
        Speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOne() {
        return TypeOne;
    }

    public void setTypeOne(String typeOne) {
        TypeOne = typeOne;
    }

    public String getTypeTwo() {
        return TypeTwo;
    }

    public void setTypeTwo(String typeTwo) {
        TypeTwo = typeTwo;
    }

    public long getHP() {
        return HP;
    }

    public void setHP(long HP) {
        this.HP = HP;
    }

    public long getAttack() {
        return Attack;
    }

    public void setAttack(long attack) {
        Attack = attack;
    }

    public long getDefense() {
        return Defense;
    }

    public void setDefense(long defense) {
        Defense = defense;
    }

    public long getSAttack() {
        return SAttack;
    }

    public void setSAttack(long SAttack) {
        this.SAttack = SAttack;
    }

    public long getSDefense() {
        return SDefense;
    }

    public void setSDefense(long SDefense) {
        this.SDefense = SDefense;
    }

    public long getSpeed() {
        return Speed;
    }

    public void setSpeed(long speed) {
        Speed = speed;
    }

    @Override
    public String toString() {
        return "PokemonParsingModel2{" +
                "name='" + name + '\'' +
                ", TypeOne='" + TypeOne + '\'' +
                ", TypeTwo='" + TypeTwo + '\'' +
                ", HP=" + HP +
                ", Attack=" + Attack +
                ", Defense=" + Defense +
                ", SAttack=" + SAttack +
                ", SDefense=" + SDefense +
                ", Speed=" + Speed +
                '}';
    }
}
