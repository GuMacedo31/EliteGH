package br.com.mackenzie.pratica.profissional.elitegh.service

import br.com.mackenzie.pratica.profissional.elitegh.domain.Role
import br.com.mackenzie.pratica.profissional.elitegh.domain.User
import br.com.mackenzie.pratica.profissional.elitegh.repository.RoleRepository
import br.com.mackenzie.pratica.profissional.elitegh.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class RoleService(private val userRepository: UserRepository, private val roleRepository: RoleRepository) {
    fun addRole(userId: Long, roleName: String): User {
        val user = userRepository.findById(userId).orElseThrow()
        val role: Role
        when (roleName) {
            "ADMIN" -> {
                role = roleRepository.findByName("ADMIN")
                user.role += role
            }

            "INSTRUCTOR" -> {
                role = roleRepository.findByName("INSTRUCTOR")
                user.role += role
            }

            else -> return user
        }

        return userRepository.save(user)
    }
}