import com.github.sobreera.application.controller.MyScalatraServlet
import org.scalatra._
import javax.servlet.ServletContext
import scalikejdbc.config.DBs

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    DBs.setup()
    context.mount(new MyScalatraServlet, "/*")
//    context.mount(classOf[org.h2.server.web.WebServlet], "/h2/*")
  }

  override def destroy(context: ServletContext): Unit = {
    super.destroy(context)
  }
}
