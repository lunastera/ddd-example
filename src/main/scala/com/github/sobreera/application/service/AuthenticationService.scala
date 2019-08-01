package com.github.sobreera.application.service

import java.sql.Connection

import com.github.sobreera.domain.repository.UserRepository

import scala.util.Try

class AuthenticationService(
  val userRepository: UserRepository
) {
  def authentication(userId: String, password: String)(implicit conn: Connection): Try[Boolean] = {
    userRepository.resolveByUserId(userId).map {
      user =>
        user.exists(_.password == password)
    }
  }
}
