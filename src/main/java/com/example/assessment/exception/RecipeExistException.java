package com.example.assessment.exception;

public class RecipeExistException extends Exception {

    public RecipeExistException() {
        super("Recipe already exists");
    }

    public RecipeExistException(String error) {
        super(error);
    }
}
