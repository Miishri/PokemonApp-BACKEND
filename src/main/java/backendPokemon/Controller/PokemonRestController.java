package backendPokemon.Controller;

import backendPokemon.Model.Pokemon;
import backendPokemon.PokemonNotFoundException.PokemonNotFoundException;
import backendPokemon.PokemonRepository.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/poke")
public class PokemonRestController {

    private PokemonRepository pokeRepo;

    @Autowired
    public PokemonRestController(PokemonRepository pokemonRepository) {
        pokeRepo = pokemonRepository;
    }

    @GetMapping("/mons")
    public List<Pokemon> getAllPokemon(){
        return pokeRepo.findAll();
    }
    @GetMapping("/{id}")
    public Pokemon getPokemon(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokeRepo.findById(id);
        if (pokemon.isEmpty()) {
            throw new PokemonNotFoundException();
        }
        return pokemon.get();
    }
    @GetMapping("/sort")
    public List<Pokemon> sortPokemonAlpha() {
        List<Pokemon> pokemon = pokeRepo.findAll();
        return pokemon.stream()
                .sorted(Comparator.comparing(Pokemon::getName))
                .collect(Collectors.toList());
    }
    @GetMapping("/stats")
    public List<Pokemon> sortPokemonStatsTotal() {
        List<Pokemon> pokemon = pokeRepo.findAll();
        return pokemon.stream()
                .sorted(Comparator.comparing(Pokemon::getTotalStats).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping("/mons/{type}")
    public List<Pokemon> getPokemonByType(@PathVariable String type) {
        List<Pokemon> pokemon = pokeRepo.findAll();
        List<Pokemon> sortedList = new ArrayList<>();

        for (Pokemon mon : pokemon) {
            String checker = type.toLowerCase();
            String typeOne = mon.getTypeOne().toLowerCase();
            String typeTwo = mon.getTypeTwo();
            if (typeTwo == null) {
                if (typeOne.equals(checker)){
                    sortedList.add(mon);
                }
            }else if ((typeTwo != null && typeTwo.toLowerCase().equals(checker))|| typeOne.equals(checker)) {
                sortedList.add(mon);
            }
        }
        return sortedList;
    }

    @GetMapping("/health")
    public List<Pokemon> getPokemonByHealth() {
        List<Pokemon> pokemon = pokeRepo.findAll();
        return pokemon.stream()
                .sorted(Comparator.comparing(Pokemon::getHP).reversed())
                .collect(Collectors.toList());
    }
    @GetMapping("/attack")
    public List<Pokemon> getPokemonByAttack() {
        List<Pokemon> pokemon = pokeRepo.findAll();
        return pokemon.stream()
                .sorted(Comparator.comparing(Pokemon::getAttack).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping("/defense")
    public List<Pokemon> getPokemonByDefense() {
        List<Pokemon> pokemon = pokeRepo.findAll();
        return pokemon.stream()
                .sorted(Comparator.comparing(Pokemon::getDefense).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping("/specialA")
    public List<Pokemon> getPokemonBySpecialAttack() {
        List<Pokemon> pokemon = pokeRepo.findAll();
        return pokemon.stream()
                .sorted(Comparator.comparing(Pokemon::getSAttack).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping("/specialD")
    public List<Pokemon> getPokemonBySpecialDefense() {
        List<Pokemon> pokemon = pokeRepo.findAll();
        return pokemon.stream()
                .sorted(Comparator.comparing(Pokemon::getSDefense).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping("/speed")
    public List<Pokemon> getPokemonBySpeed() {
        List<Pokemon> pokemon = pokeRepo.findAll();
        return pokemon.stream()
                .sorted(Comparator.comparing(Pokemon::getSpeed).reversed())
                .collect(Collectors.toList());
    }

}
