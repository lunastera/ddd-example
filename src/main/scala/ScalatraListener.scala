import com.github.sobreera.config.H2DbStarter
import javax.servlet.ServletContextEvent
import org.scalatra.servlet

class ScalatraListener extends servlet.ScalatraListener {
  override def contextInitialized(sce: ServletContextEvent): Unit = {
    new H2DbStarter().contextInitialized(sce)
    super.contextInitialized(sce)
  }
}
