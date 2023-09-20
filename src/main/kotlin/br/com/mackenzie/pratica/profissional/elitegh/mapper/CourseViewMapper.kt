package br.com.mackenzie.pratica.profissional.elitegh.mapper

import br.com.mackenzie.pratica.profissional.elitegh.domain.Course
import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.CourseView
import org.springframework.stereotype.Component

@Component
class CourseViewMapper : Mapper<Course, CourseView> {
    override fun map(t: Course): CourseView {
        return CourseView(
            title = t.title,
            description = t.description,
            instructor = t.instructor,
            content = t.content,
            prerequisites = t.prerequisites,
            available = t.available,
        )
    }
}