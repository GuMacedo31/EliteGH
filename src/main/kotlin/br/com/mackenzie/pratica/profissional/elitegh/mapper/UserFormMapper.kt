package br.com.mackenzie.pratica.profissional.elitegh.mapper

import br.com.mackenzie.pratica.profissional.elitegh.domain.Role
import br.com.mackenzie.pratica.profissional.elitegh.domain.User
import br.com.mackenzie.pratica.profissional.elitegh.domain.dto.UserForm
import org.springframework.stereotype.Component

@Component
class UserFormMapper() : Mapper<UserForm, User> {
    override fun map(t: UserForm) = User(
        name = t.name,
        email = t.email,
        password = t.password
    )

    fun map(t: UserForm, password: String, role: Role) = User(
        name = t.name,
        email = t.email,
        password = password,
        role = mutableSetOf(role)
    )
}