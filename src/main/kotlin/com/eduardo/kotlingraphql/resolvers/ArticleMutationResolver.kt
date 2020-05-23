package com.eduardo.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.eduardo.kotlingraphql.model.Article
import com.eduardo.kotlingraphql.repository.ArticleRepository
import org.springframework.stereotype.Component

@Component
class ArticleMutationResolver (private val repository: ArticleRepository): GraphQLMutationResolver {
    fun newArticle(title: String, content: String): Article {
        val article = Article(0, title, content)
        repository.save(article)
        return article
    }

    fun deleteArticle(id:Long): Boolean {
        repository.deleteById(id)
        return true
    }

    fun updateArticle(id:Long, title:String, content: String) : Article {
        val article = repository.findById(id)
        article.ifPresent {
            it.title = title
            it.content = content
            repository.save(it)
        }

        return article.get()
    }
}