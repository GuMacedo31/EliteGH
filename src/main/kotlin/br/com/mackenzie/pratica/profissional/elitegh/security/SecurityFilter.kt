package br.com.mackenzie.pratica.profissional.elitegh.security

import br.com.mackenzie.pratica.profissional.elitegh.service.JwtService
import br.com.mackenzie.pratica.profissional.elitegh.service.UserDetailsService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class SecurityFilter(
    private val jwtService: JwtService,
    private val userDetailsService: UserDetailsService
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filtmerChain: FilterChain
    ) {
        val token = recoverToken(request)
        if (token != null) {
            val subject = jwtService.validateToken(token)
            val user = userDetailsService.loadUserByUsername(subject)

            val authentication = UsernamePasswordAuthenticationToken(user, null, user.authorities)

            SecurityContextHolder.getContext().authentication = authentication
        }
        filtmerChain.doFilter(request, response)
    }

    private fun recoverToken(request: HttpServletRequest): String? {
        val authHeader = request.getHeader("Authorization")
        return if (authHeader.isNullOrEmpty()) null
        else authHeader.replace("Bearer ", "")
    }
}