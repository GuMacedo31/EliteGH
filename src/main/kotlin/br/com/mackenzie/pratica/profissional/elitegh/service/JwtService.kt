package br.com.mackenzie.pratica.profissional.elitegh.service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class JwtService(
    @Value("\${api.security.token.secret}") private val secret: String
) {

    private val algorithm = Algorithm.HMAC256(secret)

    fun generateToken(user: UserDetails): String {
        return try {
            JWT.create()
                .withIssuer("elite-gh")
                .withSubject(user.username)
                .withExpiresAt(
                    LocalDateTime.now()
                        .plusMinutes(3)
                        .toInstant(ZoneOffset.of("-03:00"))
                )
                .sign(algorithm)
        } catch (ex: JWTCreationException) {
            throw RuntimeException("Error while generating token", ex)
        }
    }

    fun validateToken(token: String): String {
        return try {
            JWT.require(algorithm)
                .withIssuer("elite-gh")
                .build()
                .verify(token)
                .subject
        } catch (ex: JWTVerificationException) {
            return ""
        }
    }
}