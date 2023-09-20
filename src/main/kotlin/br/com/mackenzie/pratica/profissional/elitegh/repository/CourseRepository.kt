package br.com.mackenzie.pratica.profissional.elitegh.repository

import br.com.mackenzie.pratica.profissional.elitegh.domain.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long> {
    fun findAllByOrderByAvailableDesc(): List<Course>
}