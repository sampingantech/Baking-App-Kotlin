package com.example.eziketobenna.bakingapp.remote.model

data class RecipeRemoteModel(
    val id: String,
    val name: String,
    val image: String,
    val servings: Int,
    val ingredients: List<IngredientRemoteModel>,
    val steps: List<StepRemoteModel>
)
