package br.com.mackenzie.pratica.profissional.elitegh.domain.dto

import br.com.mackenzie.pratica.profissional.elitegh.domain.Course

data class UserView(
    val name: String,
    val email: String,
    val enrolledCourses: MutableSet<Course>
)
