package pokemonParsing;

import org.json.simple.parser.ParseException;
import pokemonParsing.PokemonModelParsing.PokemonParsingModel2;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class test {

    private final String path = "..\\backendPokemon\\src\\main\\java\\pokemonParsing\\pokemonDataList.json";
    private ArrayList<PokemonParsingModel2> parsedPokemonList = new ArrayList<>();
    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "123";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void insertPokemons(List<PokemonParsingModel2> pokemonList) throws SQLException {

        try {
            PreparedStatement st = connect().prepareStatement("INSERT INTO pokemons (name, first_type, second_type, hp, attack, defense, special_attack, special_defense, speed) VALUES (?,?,?,?,?,?,?,?,?)");

            for (PokemonParsingModel2 pokemon : pokemonList) {
                st.setString(1, pokemon.getName());
                st.setString(2, pokemon.getTypeOne());
                st.setString(3, pokemon.getTypeTwo());
                st.setLong(4, pokemon.getHP());
                st.setLong(5, pokemon.getAttack());
                st.setLong(6, pokemon.getDefense());
                st.setLong(7, pokemon.getSAttack());
                st.setLong(8, pokemon.getSDefense());
                st.setLong(9, pokemon.getSpeed());
                st.addBatch();

                st.executeBatch();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("ERROR OCCURED WHILE PUTTING DATA INSIDE TABLE");
        }

    }

    public void parser() {
        JSONParser pokemonParser = new JSONParser();

        try (FileReader pokeReader = new FileReader(path)) {
            JSONArray pokemonArray = (JSONArray) pokemonParser.parse(pokeReader);

            for (int i = 0; i < pokemonArray.size(); i++) {

                JSONObject pokemonObject = (JSONObject) pokemonArray.get(i);

                JSONObject pokeNames = (JSONObject) pokemonObject.get("name");
                String name = (String) pokeNames.get("english");


                JSONArray typeArray = (JSONArray) pokemonObject.get("type");
                String typeOne = (String) typeArray.get(0);
                String typeTwo = null;
                if (typeArray.size() == 2) {
                    typeTwo = (String) typeArray.get(1);
                }

                JSONObject pokeStats = (JSONObject) pokemonObject.get("base");
                long HP = (long) pokeStats.get("HP");
                long Attack = (long) pokeStats.get("Attack");
                long Defense = (long) pokeStats.get("Defense");
                long SAttack = (long) pokeStats.get("Sp. Attack");
                long SDefense = (long) pokeStats.get("Sp. Defense");
                long Speed = (long) pokeStats.get("Speed");

                PokemonParsingModel2 pokemon = new PokemonParsingModel2(
                        name,
                        typeOne,
                        typeTwo,
                        HP,
                        Attack,
                        Defense,
                        SAttack,
                        SDefense,
                        Speed
                );

                parsedPokemonList.add(pokemon);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        test newTest = new test();
        newTest.parser();
        newTest.insertPokemons(newTest.parsedPokemonList);

    }

    /* Command for SQL DATABASE
    CREATE TABLE IF NOT EXISTS pokemons (
    id serial PRIMARY KEY,
    name VARCHAR (30) NOT NULL,
    first_Type VARCHAR (30) NOT NULL,
    second_Type VARCHAR (30),
    HP INT NOT NULL,
    Attack INT NOT NULL,
    Defense INT NOT NULL,
    special_Attack INT NOT NULL,
    special_Defense INT NOT NULL,
    Speed INT NOT NULL
    );
*/
}
