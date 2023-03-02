package backendPokemon.Model;

import jakarta.persistence.*;

import java.util.Comparator;

@Entity
@Table(name = "pokemons")
public class Pokemon{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "first_type")
    private String TypeOne;

    @Column(name = "second_type")
    private String TypeTwo;

    @Column(name = "hp")
    private long HP;

    @Column(name = "attack")
    private long Attack;

    @Column(name = "defense")
    private long Defense;

    @Column(name = "special_attack")
    private long SAttack;

    @Column(name = "special_defense")
    private long SDefense;

    @Column(name = "speed")
    private long Speed;

    public Pokemon(){}

    public Pokemon(String name, String typeOne, String typeTwo, long HP, long attack, long defense, long SAttack, long SDefense, long speed) {
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
    public Long getTotalStats() {
        return getHP() + getAttack() + getDefense() + getSAttack() + getSDefense() + getSpeed();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
