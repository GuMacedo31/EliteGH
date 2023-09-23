package br.com.mackenzie.pratica.profissional.elitegh.controller

import br.com.mackenzie.pratica.profissional.elitegh.service.RoleService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/role")
class RoleController(private val roleService: RoleService) {

    @PostMapping("/user/{id}/admin")
    fun addRoleAdmin(@PathVariable id: Long) {
        roleService.addRole(id, "ADMIN")
    }

    @PostMapping("/user/{id}/instructor")
    fun addRoleInstructor(@PathVariable id: Long) {
        roleService.addRole(id, "INSTRUCTOR")
    }
}