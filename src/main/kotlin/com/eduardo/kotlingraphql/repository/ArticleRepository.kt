package com.eduardo.kotlingraphql.repository

import com.eduardo.kotlingraphql.model.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : JpaRepository<Article, Long>