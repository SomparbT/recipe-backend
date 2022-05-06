package com.example.assessment.model.response;

import java.util.List;

public class GetAllRecipeNameResponse {
    private List<String> recipeNames;

    public GetAllRecipeNameResponse(List<String> recipeNames) {
        this.recipeNames = recipeNames;
    }

    public List<String> getRecipeNames() {
        return recipeNames;
    }

    public void setRecipeNames(List<String> recipeNames) {
        this.recipeNames = recipeNames;
    }

}
