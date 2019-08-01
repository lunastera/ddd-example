package com.github.sobreera.application.controller

import java.sql.Connection

import com.github.sobreera.application.service.AuthenticationService
import org.scalatra.ScalatraServlet

import scala.util.Success

class UserController(connection: Connection, auth: AuthenticationService) extends ScalatraServlet {
  implicit val conn: Connection = connection

  get("/") {
    views.html.hello()
  }

  get("/:id") {
    val userId = params("id")
    val pass = "era"
  }

  post("/login") {
    val userId = params("userId")
    val pass = params("password")
    val user = auth.authentication(userId, pass)
    auth.authentication(userId, pass) match {
      case Success(value) if value => {
        session("userId") -> userId
      }
      case _ => halt(403)
    }
  }
}
