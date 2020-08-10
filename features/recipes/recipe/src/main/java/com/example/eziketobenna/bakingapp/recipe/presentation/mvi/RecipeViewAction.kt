package com.example.eziketobenna.bakingapp.recipe.presentation.mvi

import com.example.eziketobenna.bakingapp.presentation.mvi.ViewAction

sealed class RecipeViewAction : ViewAction {
    object LoadInitialAction : RecipeViewAction()
    data class LikeAction(val recipeId: Int) : RecipeViewAction()
    object RetryFetchAction : RecipeViewAction()
    object RefreshRecipesAction : RecipeViewAction()
}
