package com.eduardo.kotlingraphql.resolvers

import com.eduardo.kotlingraphql.repository.ArticleRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.eduardo.kotlingraphql.model.Article
import org.springframework.stereotype.Component

@Component
class ArticleQueryResolver(val repository: ArticleRepository) : GraphQLQueryResolver {
    fun articles(): List<Article> {
        return repository.findAll()
    }
}