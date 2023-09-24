package br.com.mackenzie.pratica.profissional.elitegh.mapper

import br.com.mackenzie.pratica.profissional.elitegh.domain.Course
import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.CourseForm
import br.com.mackenzie.pratica.profissional.elitegh.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class CourseFormMapper : Mapper<CourseForm, Course> {
    override fun map(t: CourseForm): Course {
        return Course(
            title = t.title,
            description = t.description,
            instructor = t.instructorId,
            content = t.content,
            prerequisites = t.prerequisites,
            available = t.available,
        )
    }
}