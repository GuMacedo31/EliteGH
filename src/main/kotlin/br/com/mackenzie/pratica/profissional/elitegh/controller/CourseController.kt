package br.com.mackenzie.pratica.profissional.elitegh.controller

import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.CourseForm
import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.CourseView
import br.com.mackenzie.pratica.profissional.elitegh.service.CourseService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/course")
class CourseController(private val courseService: CourseService) {

    @GetMapping("/{id}")
    fun retrieveById(@PathVariable id: Long): CourseView {
        return courseService.retrieveById(id)
    }

    @GetMapping
    fun retrieveAll(): List<CourseView> {
        return courseService.retrieveAll()
    }

    @PostMapping
    fun create(
        @RequestBody courseForm: CourseForm
    ) {
        courseService.create(courseForm)
    }
}