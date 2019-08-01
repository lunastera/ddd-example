import com.github.sobreera.application.controller.{MyScalatraServlet, UserController}
import com.github.sobreera.application.service.AuthenticationService
import com.github.sobreera.config.H2DbStarter
import com.github.sobreera.domain.repository.UserRepository
import org.scalatra._
import javax.servlet.ServletContext
import scalikejdbc.{ConnectionPool, DB}
import scalikejdbc.config.DBs

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    DBs.setup()
    val conn = ConnectionPool.borrow()
    val authenticationService = new AuthenticationService(new UserRepository)
    context.mount(new UserController(conn, authenticationService), "/user/*")
//    context.mount(new MyScalatraServlet, "/*")
//    context.mount(classOf[org.h2.server.web.WebServlet], "/h2/*")
  }

  override def destroy(context: ServletContext): Unit = {
    super.destroy(context)
  }
}
