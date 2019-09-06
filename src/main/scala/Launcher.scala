import java.sql.DriverManager

import org.apache.logging.log4j.scala.Logging
/**
  *
  */
object Launcher extends App with Logging{

  try {
    H2Launcher.startDB()
    // scalastyle:off
    Class.forName(Configuration.driver)
    val connection = DriverManager.getConnection(Configuration.url, Configuration.username, Configuration.password)
    logger.info(s"Connection Established: ${connection.getMetaData}/${connection.getCatalog}")
    val statement = connection.createStatement()
    H2Launcher.createSchema(statement)
    val rs = H2Launcher.getSchemas(statement)

    while (rs.next) {
      val schemaName = rs.getString(1)
      logger.info(s"Schema: ${schemaName}")
    }

    // H2Launcher.createTable(statement)

    val rt = H2Launcher.getTables(statement)

    while (rt.next) {
      val tableName = rt.getString(1)
      val schemaName = rt.getString(2)
      logger.info(s"Table: ${tableName} Schema: ${schemaName}")
    }

    val dsConnection = H2BasicDataSource.connectionPool.getConnection
    val st = dsConnection.createStatement()

    // H2Launcher.insertData(statement)

    val ru = H2Launcher.getData(st)

    while (ru.next) {
      val id = ru.getString(1)
      val title = ru.getString(2)
      val author = ru.getString(3)
      logger.info(s"Id: ${id} Title: ${title} Author: ${author}")
    }

    connection.close()
    H2Launcher.stopDB()
  } catch {
    // scalastyle: off
    case e : Exception => logger.info(s"Error: ${e.printStackTrace()}")
  }
}
