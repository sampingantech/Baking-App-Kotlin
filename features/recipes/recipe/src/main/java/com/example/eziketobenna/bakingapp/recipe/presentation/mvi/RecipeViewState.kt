package com.example.eziketobenna.bakingapp.recipe.presentation.mvi

import com.example.eziketobenna.bakingapp.model.RecipeModel
import com.example.eziketobenna.bakingapp.presentation.event.ViewEvent
import com.example.eziketobenna.bakingapp.presentation.mvi.ViewState

data class RecipeViewState private constructor(
        val isLoading: Boolean,
        val isRefreshing: Boolean,
        val isDataUnavailable: Boolean,
        val error: String?,
        val errorEvent: ViewEvent<String>?,
        val recipes: List<RecipeModel>,
        val recipe: RecipeModel?
) : ViewState {

    val loadingState: RecipeViewState
        get() = this.copy(
                isLoading = true,
                isRefreshing = false,
                isDataUnavailable = false,
                error = null,
                recipe = null,
                errorEvent = null
        )

    val refreshingState: RecipeViewState
        get() = this.copy(
                isLoading = false,
                isRefreshing = true,
                isDataUnavailable = false,
                error = null,
                recipe = null,
                errorEvent = null
        )

    val emptyState: RecipeViewState
        get() = this.copy(
                isLoading = false,
                isRefreshing = false,
                isDataUnavailable = true,
                error = null,
                recipe = null,
                errorEvent = null
        )

    fun noDataErrorState(cause: String): RecipeViewState = this.copy(
            isLoading = false,
            isRefreshing = false,
            isDataUnavailable = false,
            error = cause,
            recipe = null,
            errorEvent = null
    )

    fun dataAvailableErrorState(cause: String): RecipeViewState = this.copy(
            isLoading = false,
            isRefreshing = false,
            isDataUnavailable = false,
            error = null,
            recipe = null,
            errorEvent = ViewEvent(cause)
    )

    fun likedState(recipe: RecipeModel): RecipeViewState = this.copy(
            isLoading = false,
            isRefreshing = false,
            isDataUnavailable = false,
            error = null,
            errorEvent = null,
            recipe = recipe,
            recipes = recipes.map { oldRecipe ->
                val newRecipe = recipe

                if (oldRecipe.id == recipe.id) newRecipe
                else oldRecipe
            }
    )

    fun loadedState(recipes: List<RecipeModel>): RecipeViewState = this.copy(
            isLoading = false,
            isRefreshing = false,
            isDataUnavailable = false,
            error = null,
            errorEvent = null,
            recipe = null,
            recipes = recipes
    )

    val liked: Boolean
        get() = this.recipe != null

    val isNoDataError: Boolean
        get() = this.error != null

    val isDataAvailableError: Boolean
        get() = this.errorEvent != null

    companion object {
        val init: RecipeViewState
            get() = RecipeViewState(
                    isLoading = false,
                    isRefreshing = false,
                    error = null,
                    isDataUnavailable = false,
                    errorEvent = null,
                    recipes = emptyList(),
                    recipe = null
            )
    }
}
