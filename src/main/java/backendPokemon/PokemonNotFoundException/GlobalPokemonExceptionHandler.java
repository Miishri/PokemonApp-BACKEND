package backendPokemon.PokemonNotFoundException;

import backendPokemon.Model.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalPokemonExceptionHandler {

    @ExceptionHandler(PokemonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public PokemonNotFound handleException(PokemonNotFoundException exception) {
        PokemonNotFound error = new PokemonNotFound();
        error.setPokeMessage("Pokemon was not found with the ID/Name");
        return error;
    }
}
