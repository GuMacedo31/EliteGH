package br.com.mackenzie.pratica.profissional.elitegh.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    @Column(unique = true)
    val email: String,
    @JsonIgnore
    var password: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "course_student",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "course_id")]
    )
    var courses: MutableSet<Course> = linkedSetOf(),

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_role")
    var role: MutableSet<Role> = mutableSetOf()
)
