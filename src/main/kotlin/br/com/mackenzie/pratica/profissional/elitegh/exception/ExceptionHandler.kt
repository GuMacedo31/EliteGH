package br.com.mackenzie.pratica.profissional.elitegh.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionHandler {


    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleUserNotFoundException(ex: UserNotFoundException) = ex.message

    @ExceptionHandler(CourseNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleCourseNotFoundException(ex: CourseNotFoundException) = ex.message

}