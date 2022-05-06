package com.example.assessment.mapper;

import com.example.assessment.model.response.GetAllRecipeNameResponse;

import java.util.ArrayList;
import java.util.List;

public class ListStringToGetAllRecipeNameResponse {

    public static GetAllRecipeNameResponse map(List<String> recipeNames) {
        return new GetAllRecipeNameResponse(new ArrayList<>(recipeNames));
    }

}
