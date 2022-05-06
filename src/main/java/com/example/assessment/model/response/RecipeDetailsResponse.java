package com.example.assessment.model.response;

import java.util.List;

public class RecipeDetailsResponse {

    private List<String> ingredients;

    private int numSteps;

    public RecipeDetailsResponse(List<String> ingredients, int numSteps) {
        this.ingredients = ingredients;
        this.numSteps = numSteps;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getNumSteps() {
        return numSteps;
    }

    public void setNumSteps(int numSteps) {
        this.numSteps = numSteps;
    }
}
