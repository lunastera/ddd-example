package com.github.sobreera.application.controller

import org.scalatra._

class MyScalatraServlet extends ScalatraServlet {
  get("/") {
    views.html.hello()
  }

  post("/login") {

  }
}
