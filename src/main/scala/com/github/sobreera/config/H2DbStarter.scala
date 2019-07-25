package com.github.sobreera.config

import java.io.InputStreamReader

import javax.servlet.ServletContextEvent
import org.h2.server.web.DbStarter
import org.h2.tools.RunScript

import scala.util.{Failure, Success, Try}

class H2DbStarter extends DbStarter {
  override def contextInitialized(servletContextEvent: ServletContextEvent): Unit = {
    Try {
      super.contextInitialized(servletContextEvent)
      val scriptConfig = servletContextEvent.getServletContext.getInitParameter("db.scripts")
      val scripts = scriptConfig.split(",")
      scripts.foreach { script =>
        println(getConnection.getMetaData)
        RunScript.execute(getConnection, new InputStreamReader(getClass.getResourceAsStream(script)))
      }
    } match {
      case Success(_) => println("Success.")
      case Failure(exception) => exception.printStackTrace()
    }
  }
}
