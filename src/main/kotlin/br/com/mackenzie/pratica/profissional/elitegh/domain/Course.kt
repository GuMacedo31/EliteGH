package br.com.mackenzie.pratica.profissional.elitegh.domain

import jakarta.persistence.*

@Entity
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(unique = true)
    val title: String,
    val description: String,
    val instructor: Long,
    val content: String,
    val prerequisites: String,
    val available: Boolean
)
