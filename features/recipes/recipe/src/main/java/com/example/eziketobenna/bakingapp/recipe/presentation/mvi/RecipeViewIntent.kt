package com.example.eziketobenna.bakingapp.recipe.presentation.mvi

import com.example.eziketobenna.bakingapp.presentation.mvi.ViewIntent

sealed class RecipeViewIntent : ViewIntent {
    object LoadInitialViewIntent : RecipeViewIntent()
    data class LikeViewIntent(val recipeId: Int) : RecipeViewIntent()
    object RetryFetchViewIntent : RecipeViewIntent()
    object RecipeRefreshViewIntent : RecipeViewIntent()
}
