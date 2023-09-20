package br.com.mackenzie.pratica.profissional.elitegh.domain.dto

data class CourseForm(
    val title: String,
    val description: String,
    val instructorId: Long,
    val content: String,
    val prerequisites: String,
    val available: Boolean,
)
