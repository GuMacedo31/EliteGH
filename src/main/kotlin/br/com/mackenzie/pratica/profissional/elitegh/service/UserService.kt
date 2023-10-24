package br.com.mackenzie.pratica.profissional.elitegh.service

import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.UserView
import br.com.mackenzie.pratica.profissional.elitegh.exception.CourseNotFoundException
import br.com.mackenzie.pratica.profissional.elitegh.exception.UserNotFoundException
import br.com.mackenzie.pratica.profissional.elitegh.mapper.UserViewMapper
import br.com.mackenzie.pratica.profissional.elitegh.repository.CourseRepository
import br.com.mackenzie.pratica.profissional.elitegh.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val courseRepository: CourseRepository,
    private val userViewMapper: UserViewMapper
) {

    fun retrieveById(id: Long): UserView {
        val result = userRepository.findById(id).orElseThrow { UserNotFoundException("Usuário não encontrado") }
        return userViewMapper.map(result)


    }

    fun enrollUserInCourse(userId: Long, courseId: Long) {
        val user = userRepository.findById(userId).orElseThrow { UserNotFoundException("Usuário não encontrado") }
        val course = courseRepository.findById(courseId).orElseThrow { CourseNotFoundException("Curso não encontrado") }

        user.courses.add(course)
    }


}
