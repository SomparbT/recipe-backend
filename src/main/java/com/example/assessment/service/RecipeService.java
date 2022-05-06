package com.example.assessment.service;

import com.example.assessment.exception.RecipeExistException;
import com.example.assessment.exception.RecipeNotExistException;
import com.example.assessment.model.request.RecipeRequest;
import com.example.assessment.model.response.GetAllRecipeNameResponse;
import com.example.assessment.model.response.GetRecipeDetailsByNameResponse;

public interface RecipeService {

    GetAllRecipeNameResponse getAllRecipeName();

    GetRecipeDetailsByNameResponse getRecipeDetailsByName(String name);

    void addRecipe(RecipeRequest request) throws RecipeExistException;

    void updateRecipe(RecipeRequest request) throws RecipeNotExistException;

}
