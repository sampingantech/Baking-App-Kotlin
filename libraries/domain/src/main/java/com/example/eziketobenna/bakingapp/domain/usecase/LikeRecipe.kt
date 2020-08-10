package com.example.eziketobenna.bakingapp.domain.usecase

import com.example.eziketobenna.bakingapp.domain.executor.PostExecutionThread
import com.example.eziketobenna.bakingapp.domain.model.Recipe
import com.example.eziketobenna.bakingapp.domain.repository.RecipeRepository
import com.example.eziketobenna.bakingapp.domain.usecase.base.FlowUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/**
 * Created by mochadwi on 8/9/20.
 * Copyright (c) 2020 sampingan.co.id. All rights reserved.
 */

class LikeRecipe @Inject constructor(
        private val recipeRepository: RecipeRepository,
        postExecutionThread: PostExecutionThread
) : FlowUseCase<Int, Recipe>(postExecutionThread) {
    override fun execute(params: Int?): Flow<Recipe> =
            // TODO(mochadwi): 8/9/20 Will reduce below boilerplate using extensions
            flow {
                if (params != null) emit(recipeRepository.likeRecipe(params))
                else throw UnsupportedOperationException("No param provided for likeRecipe")
            }
}