import org.apache.commons.dbcp2.BasicDataSource

/**
  *
  */
object H2BasicDataSource {

  val connectionPool = new BasicDataSource()

  connectionPool.setDriverClassName(Configuration.driver)
  connectionPool.setUrl(Configuration.url)
  connectionPool.setUsername(Configuration.username)
  connectionPool.setPassword(Configuration.password)
  connectionPool.setInitialSize(3)

}
