package com.example.assessment.model.response;

public class GetRecipeDetailsByNameResponse {

    private RecipeDetailsResponse details;

    public GetRecipeDetailsByNameResponse(RecipeDetailsResponse details) {
        this.details = details;
    }

    public RecipeDetailsResponse getDetails() {
        return details;
    }

    public void setDetails(RecipeDetailsResponse details) {
        this.details = details;
    }
}
