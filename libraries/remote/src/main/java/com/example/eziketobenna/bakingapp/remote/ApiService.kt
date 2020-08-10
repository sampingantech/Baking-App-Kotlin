package com.example.eziketobenna.bakingapp.remote

import com.example.eziketobenna.bakingapp.remote.model.RecipeRemoteModel
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("baking_json")
    suspend fun fetchRecipes(): List<RecipeRemoteModel>

    @PUT("baking_json/{id}")
    suspend fun likeRecipe(@Path("id") recipeId: Int): RecipeRemoteModel
}
