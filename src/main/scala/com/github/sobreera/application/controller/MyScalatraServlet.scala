package com.github.sobreera.application.controller

import org.scalatra._
import scalikejdbc.{DB, _}

class MyScalatraServlet extends ScalatraServlet {
  get("/") {
    views.html.hello()
  }
}
