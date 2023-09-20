package br.com.mackenzie.pratica.profissional.elitegh.domain.dto

data class CourseView(
    val title: String,
    val description: String,
    val instructor: Long,
    val content: String,
    val prerequisites: String,
    val available: Boolean,
)
