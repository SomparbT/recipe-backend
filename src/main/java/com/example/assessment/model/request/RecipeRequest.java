package com.example.assessment.model.request;

import java.util.List;

public class RecipeRequest {

    private String name;
    private List<String> ingredients;
    private List<String> instructions;

    public RecipeRequest() {
        super();
    }

    public RecipeRequest(String name, List<String> ingredients, List<String> instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }
}
