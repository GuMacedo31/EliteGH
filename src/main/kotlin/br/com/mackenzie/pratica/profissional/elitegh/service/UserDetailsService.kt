package br.com.mackenzie.pratica.profissional.elitegh.service

import br.com.mackenzie.pratica.profissional.elitegh.domain.UserDetail
import br.com.mackenzie.pratica.profissional.elitegh.exception.UserNotFoundException
import br.com.mackenzie.pratica.profissional.elitegh.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByEmail(username)
            .orElseThrow { UserNotFoundException("Usuário inexistente ou senha inválida") }
        return UserDetail(user)
    }
}