package br.com.mackenzie.pratica.profissional.elitegh.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val description: String,
    val instructor: Long,
    val content: String,
    val prerequisites: String,
    val available: Boolean
)
