package br.com.mackenzie.pratica.profissional.elitegh.controller


import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.UserForm
import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.UserView
import br.com.mackenzie.pratica.profissional.elitegh.service.UserService
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @GetMapping("/{id}")
    fun retrieveUser(@PathVariable id: Long): UserView {
        return userService.retrieveById(id)
    }

    @PostMapping
    @Transactional
    fun createUser(@RequestBody userForm: UserForm) {
        userService.create(userForm)
    }

    @PutMapping("/{userId}/courses/{courseId}")
    @Transactional
    fun enrollUserInCourse(
        @PathVariable userId: Long,
        @PathVariable courseId: Long
    ) {
        userService.enrollUserInCourse(userId, courseId)
    }
}