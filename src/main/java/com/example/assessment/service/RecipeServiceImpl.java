package com.example.assessment.service;

import com.example.assessment.dao.RecipeDao;
import com.example.assessment.exception.RecipeExistException;
import com.example.assessment.exception.RecipeNotExistException;
import com.example.assessment.mapper.RecipeRequestToRecipeDto;
import com.example.assessment.mapper.ListStringToGetAllRecipeNameResponse;
import com.example.assessment.mapper.RecipeDtoToGetRecipeDetailsByNameResponse;
import com.example.assessment.model.dto.RecipeDto;
import com.example.assessment.model.request.RecipeRequest;
import com.example.assessment.model.response.GetAllRecipeNameResponse;
import com.example.assessment.model.response.GetRecipeDetailsByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("RecipeService")
public class RecipeServiceImpl implements RecipeService {

    private RecipeDao recipeDao;

    @Autowired
    public RecipeServiceImpl(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @Override
    public GetAllRecipeNameResponse getAllRecipeName() {
        return ListStringToGetAllRecipeNameResponse.map(recipeDao.getAllRecipeName());
    }

    @Override
    public GetRecipeDetailsByNameResponse getRecipeDetailsByName(String name) {
        RecipeDto recipeDto = recipeDao.getRecipeByName(name);
        if (recipeDto == null) return null;
        return RecipeDtoToGetRecipeDetailsByNameResponse.map(recipeDto);
    }

    @Override
    public void addRecipe(RecipeRequest request) throws RecipeExistException {
        RecipeDto newDto = RecipeRequestToRecipeDto.map(request);
        RecipeDto existingDto = recipeDao.getRecipeByName(newDto.getName());
        if (existingDto != null) {
            throw new RecipeExistException();
        }
        recipeDao.addRecipe(newDto);
    }

    @Override
    public void updateRecipe(RecipeRequest request) throws RecipeNotExistException {
        RecipeDto newDto = RecipeRequestToRecipeDto.map(request);
        RecipeDto existingDto = recipeDao.getRecipeByName(newDto.getName());
        if (existingDto == null) {
            throw new RecipeNotExistException();
        }
        recipeDao.updateRecipe(newDto);
    }
}
