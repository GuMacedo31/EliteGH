package br.com.mackenzie.pratica.profissional.elitegh.service

import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.UserForm
import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.UserView
import br.com.mackenzie.pratica.profissional.elitegh.exception.NotFoundException
import br.com.mackenzie.pratica.profissional.elitegh.mapper.UserFormMapper
import br.com.mackenzie.pratica.profissional.elitegh.mapper.UserViewMapper
import br.com.mackenzie.pratica.profissional.elitegh.repository.CourseRepository
import br.com.mackenzie.pratica.profissional.elitegh.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val courseRepository: CourseRepository,
    private val userViewMapper: UserViewMapper,
    private val userFormMapper: UserFormMapper
) {

    fun retrieveById(id: Long): UserView {
        val result = userRepository.findById(id).orElseThrow { NotFoundException("Usuário não encontrado") }
        return userViewMapper.map(result)


    }

    fun create(userForm: UserForm) {
        val user = userFormMapper.map(userForm)
        userRepository.save(user)
    }

    fun enrollUserInCourse(userId: Long, courseId: Long) {
        val user = userRepository.findById(userId).orElseThrow { NotFoundException("Usuário não encontrado") }
        val course = courseRepository.findById(courseId).orElseThrow { NotFoundException("Curso não encontrado") }

        user.courses.add(course)
    }


}
