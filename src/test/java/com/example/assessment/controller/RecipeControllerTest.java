package com.example.assessment.controller;

import com.example.assessment.mapper.ListStringToGetAllRecipeNameResponse;
import com.example.assessment.mapper.RecipeDtoToGetRecipeDetailsByNameResponse;
import com.example.assessment.model.dto.RecipeDto;
import com.example.assessment.model.request.RecipeRequest;
import com.example.assessment.model.response.GetAllRecipeNameResponse;
import com.example.assessment.model.response.GetRecipeDetailsByNameResponse;
import com.example.assessment.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RecipeController.class)
@ActiveProfiles("test")
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getAllRecipeName() throws Exception {
        List<String> recipeNameList = new ArrayList<>(Arrays.asList("hamburger", "frenchFries"));
        GetAllRecipeNameResponse response = ListStringToGetAllRecipeNameResponse.map(recipeNameList);
        Mockito.when(recipeService.getAllRecipeName()).thenReturn(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/recipes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.recipeNames[0]").value("hamburger"))
                .andExpect(jsonPath("$.recipeNames[1]").value("frenchFries"));
    }

    @Test
    public void getRecipeDetailsByNameExist() throws Exception {
        String name = "hamburger";
        List<String> ingredients = new ArrayList<>(Arrays.asList("meat", "bun", "onion", "tomato"));
        List<String> instructions = new ArrayList<>(Arrays.asList("prepare all ingredients", "put everything together"));
        RecipeDto recipe = new RecipeDto(name, ingredients, instructions);
        GetRecipeDetailsByNameResponse response = RecipeDtoToGetRecipeDetailsByNameResponse.map(recipe);
        Mockito.when(recipeService.getRecipeDetailsByName(name)).thenReturn(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/recipes/details/" + name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.details.ingredients[0]").value("meat"))
                .andExpect(jsonPath("$.details.numSteps").value(2));
    }

    @Test
    public void addRecipeNotExist() throws Exception {
        String name = "hamburger";
        List<String> ingredients = new ArrayList<>(Arrays.asList("meat", "bun", "onion", "tomato"));
        List<String> instructions = new ArrayList<>(Arrays.asList("prepare all ingredients", "put everything together"));
        RecipeRequest request = new RecipeRequest(name, ingredients, instructions);
        Mockito.doNothing().when(recipeService).addRecipe(request);
        mockMvc.perform(MockMvcRequestBuilders.post("/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

}
