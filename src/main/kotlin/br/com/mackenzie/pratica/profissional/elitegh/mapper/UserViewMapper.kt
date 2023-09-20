package br.com.mackenzie.pratica.profissional.elitegh.mapper

import br.com.mackenzie.pratica.profissional.elitegh.domain.User
import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.UserView
import org.springframework.stereotype.Component

@Component
class UserViewMapper() : Mapper<User, UserView> {
    override fun map(t: User) = UserView(
        name = t.name,
        email = t.email,
        enrolledCourses = t.courses
    )
}