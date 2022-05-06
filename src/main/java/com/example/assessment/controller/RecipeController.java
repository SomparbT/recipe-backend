package com.example.assessment.controller;

import com.example.assessment.exception.RecipeExistException;
import com.example.assessment.exception.RecipeNotExistException;
import com.example.assessment.model.request.RecipeRequest;
import com.example.assessment.model.response.EmptyResponse;
import com.example.assessment.model.response.GetAllRecipeNameResponse;
import com.example.assessment.model.response.GetRecipeDetailsByNameResponse;
import com.example.assessment.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController (RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<GetAllRecipeNameResponse> getAllRecipeName() {
        return ResponseEntity.ok(recipeService.getAllRecipeName());
    }

    @GetMapping("/details/{name}")
    public ResponseEntity getRecipeDetailsByName(@PathVariable String name) {
        GetRecipeDetailsByNameResponse response = recipeService.getRecipeDetailsByName(name);
        return response == null ? ResponseEntity.ok(new EmptyResponse()) : ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity addRecipe(@RequestBody RecipeRequest recipeRequest) throws RecipeExistException {
        recipeService.addRecipe(recipeRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateRecipe(@RequestBody RecipeRequest recipeRequest) throws RecipeNotExistException {
        recipeService.updateRecipe(recipeRequest);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
