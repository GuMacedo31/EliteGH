package br.com.mackenzie.pratica.profissional.elitegh.service

import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.CourseForm
import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.CourseView
import br.com.mackenzie.pratica.profissional.elitegh.exception.NotFoundException
import br.com.mackenzie.pratica.profissional.elitegh.mapper.CourseFormMapper
import br.com.mackenzie.pratica.profissional.elitegh.mapper.CourseViewMapper
import br.com.mackenzie.pratica.profissional.elitegh.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val courseRepository: CourseRepository,
    private val courseViewMapper: CourseViewMapper,
    private val courseFormMapper: CourseFormMapper
) {

    fun retrieveById(id: Long): CourseView {
        return courseRepository.findById(id).map {
            courseViewMapper.map(it)
        }.orElseThrow { NotFoundException("Curso não encontrado") }
    }

    fun retrieveAll(): List<CourseView> {
        val courses = courseRepository.findAllByOrderByAvailableDesc()
        return courses.map { course ->
            courseViewMapper.map(course)
        }
    }

    fun retrieveByTitle(courseTitle: String): CourseView {
        return courseViewMapper.map(courseRepository.findByTitle(courseTitle))
    }

    fun create(courseForm: CourseForm) {
        val course = courseFormMapper.map(courseForm)
        courseRepository.save(course)
    }

}
