package com.example.assessment.exception;

public class RecipeNotExistException extends Exception {

    public RecipeNotExistException() {
        super("Recipe does not exist");
    }

    public RecipeNotExistException(String error) {
        super(error);
    }
}
