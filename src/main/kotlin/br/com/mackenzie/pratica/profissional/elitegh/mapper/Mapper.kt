package br.com.mackenzie.pratica.profissional.elitegh.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}