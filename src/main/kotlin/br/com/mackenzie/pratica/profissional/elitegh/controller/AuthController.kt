package br.com.mackenzie.pratica.profissional.elitegh.controller

import br.com.mackenzie.pratica.profissional.elitegh.domain.LoginForm
import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.UserForm
import br.com.mackenzie.pratica.profissional.elitegh.mapper.UserFormMapper
import br.com.mackenzie.pratica.profissional.elitegh.repository.RoleRepository
import br.com.mackenzie.pratica.profissional.elitegh.repository.UserRepository
import br.com.mackenzie.pratica.profissional.elitegh.service.JwtService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val userFormMapper: UserFormMapper,
    private val encoder: PasswordEncoder,
    private val roleRepository: RoleRepository,
    private val userRepository: UserRepository,
    private val jwtService: JwtService
) {

    @PostMapping("/login")
    fun login(@RequestBody loginForm: LoginForm): String {
        val usernamePassword = UsernamePasswordAuthenticationToken(loginForm.email, loginForm.password)
        val auth = authenticationManager.authenticate(usernamePassword)

        return jwtService.generateToken(auth.principal as UserDetails)
    }

    @PostMapping("/register")
    fun register(@RequestBody userForm: UserForm) {
        val role = roleRepository.findByName("USER")
        val user = userFormMapper.map(userForm, encoder.encode(userForm.password), role)
        userRepository.save(user)
    }
}