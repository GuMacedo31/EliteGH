package br.com.mackenzie.pratica.profissional.elitegh.repository

import br.com.mackenzie.pratica.profissional.elitegh.domain.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(name: String): Role
}