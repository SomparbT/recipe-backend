package com.example.assessment.mapper;

import com.example.assessment.model.dto.RecipeDto;
import com.example.assessment.model.request.RecipeRequest;

import java.util.ArrayList;

public class RecipeRequestToRecipeDto {

    public static RecipeDto map(RecipeRequest request) {
        return new RecipeDto(request.getName(), new ArrayList<>(request.getIngredients()), new ArrayList<>(request.getInstructions()));
    }
}
