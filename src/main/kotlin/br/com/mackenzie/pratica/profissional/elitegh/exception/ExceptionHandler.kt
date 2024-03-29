package br.com.mackenzie.pratica.profissional.elitegh.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.sql.SQLIntegrityConstraintViolationException

@ControllerAdvice
class ExceptionHandler {


    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleUserNotFoundException(ex: UserNotFoundException): ResponseEntity<Any> {
        val response = mapOf("message" to ex.message)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response)
    }

    @ExceptionHandler(CourseNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleCourseNotFoundException(ex: CourseNotFoundException): ResponseEntity<Any> {
        val response = mapOf("message" to ex.message)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response)
    }

    @ExceptionHandler(AuthenticationException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleAuthException(ex: AuthenticationException): ResponseEntity<Any> {
        val response = mapOf("message" to ex.message)
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response)
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleAuthException(): ResponseEntity<Any> {
        val response = mapOf("message" to "Email já cadastrado")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response)
    }

}