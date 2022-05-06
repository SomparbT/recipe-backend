package com.example.assessment.dao;

import com.example.assessment.model.dto.RecipeDto;

import java.util.List;

public interface RecipeDao {

    List<String> getAllRecipeName();

    RecipeDto getRecipeByName(String name);

    void addRecipe(RecipeDto recipeDto);

    void updateRecipe(RecipeDto recipeDto);

}
