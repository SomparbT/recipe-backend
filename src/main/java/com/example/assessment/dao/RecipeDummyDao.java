package com.example.assessment.dao;

import com.example.assessment.model.dto.RecipeDto;
import com.example.assessment.model.dto.RecipesDto;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RecipeDummyDao implements RecipeDao {

    private static RecipesDto DB;

    static {
        String jsonString;
        try {
            byte[] encoded = Files.readAllBytes(Paths.get("src/main/resources/data.json"));
            jsonString = new String(encoded, StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        DB = gson.fromJson(jsonString , RecipesDto.class);
    }

    @Override
    public List<String> getAllRecipeName() {
        return DB.getRecipes().stream().map(RecipeDto::getName).collect(Collectors.toList());
    }

    @Override
    public RecipeDto getRecipeByName(String name) {
        return DB.getRecipes().stream().filter(recipe -> recipe.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void addRecipe(RecipeDto recipeDto) {
        DB.getRecipes().add(recipeDto);
    }

    @Override
    public void updateRecipe(RecipeDto recipeDto) {
        RecipeDto existingDto = getRecipeByName(recipeDto.getName());
        existingDto.setIngredients(recipeDto.getIngredients());
        existingDto.setInstructions(recipeDto.getInstructions());
    }

}
