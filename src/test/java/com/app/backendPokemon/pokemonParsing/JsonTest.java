package com.app.backendPokemon.pokemonParsing;

import com.app.backendPokemon.pokemonParsing.POJO.jsonPojoTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import pokemonParsing.Json;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    private String testSource = "{ \"title\": \"Coder From Scratch\"}";
    @Test
    void parser() {

        try {
            JsonNode node = Json.parser(testSource);
            assertEquals(node.get("title").asText(), "Coder From Scratch");


        }catch (Exception e) {

        }
    }

    @Test
    void toPokemon() throws IOException {
        JsonNode node = Json.parser(testSource);

        jsonPojoTest pojoTester = Json.toPokemon(node, jsonPojoTest.class);

        assertEquals(pojoTester.getTitle(), "Coder From Scratch");
    }
}