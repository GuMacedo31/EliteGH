package br.com.mackenzie.pratica.profissional.elitegh.mapper

import br.com.mackenzie.pratica.profissional.elitegh.domain.Course
import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.CourseForm
import br.com.mackenzie.pratica.profissional.elitegh.exception.NotFoundException
import br.com.mackenzie.pratica.profissional.elitegh.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class CourseFormMapper(private val userRepository: UserRepository) : Mapper<CourseForm, Course> {
    override fun map(t: CourseForm): Course {
        return Course(
            title = t.title,
            description = t.description,
            instructor = userRepository.findById(t.instructorId)
                .orElseThrow { NotFoundException("Instrutor não encontrado") }.id!!,
            content = t.content,
            prerequisites = t.prerequisites,
            available = t.available,
        )
    }
}