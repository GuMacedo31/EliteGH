package br.com.mackenzie.pratica.profissional.elitegh.repository

import br.com.mackenzie.pratica.profissional.elitegh.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
