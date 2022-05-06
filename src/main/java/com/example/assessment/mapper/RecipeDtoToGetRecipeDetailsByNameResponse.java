package com.example.assessment.mapper;

import com.example.assessment.model.dto.RecipeDto;
import com.example.assessment.model.response.GetRecipeDetailsByNameResponse;
import com.example.assessment.model.response.RecipeDetailsResponse;

import java.util.ArrayList;

public class RecipeDtoToGetRecipeDetailsByNameResponse {

    public static GetRecipeDetailsByNameResponse map(RecipeDto recipeDto) {
        RecipeDetailsResponse recipeDetailsResponse = new RecipeDetailsResponse(new ArrayList<>(recipeDto.getIngredients()), recipeDto.getInstructions().size());
        return new GetRecipeDetailsByNameResponse(recipeDetailsResponse);
    }

}
