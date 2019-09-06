import java.sql.{ResultSet, Statement}

import org.h2.tools.Server

/**
  *
  */
object H2Launcher {

  /**
    * Launches H2 Server instance, It´s created on tcp://localhost:9092,
    * it also create a db file on User root directory
    */
  def startDB(): Unit = Server.createTcpServer( "-tcpAllowOthers").start()

  /**
    * Stops H2 Server instance
    */
  def stopDB(): Unit = Server.shutdownTcpServer(Configuration.base, "", true, true)

  /**
    *
    * @param st receives an statement
    * @return a ResultSet
    */
  def createSchema(st: Statement): Int = st.executeUpdate(Querys.createSchema)

  /**
    *
    * @param st receives an statement
    * @return a ResultSet
    */
  def getSchemas(st: Statement): ResultSet = st.executeQuery(Querys.showSchemas)

  /**
    *
    * @param st receives an statement
    * @return a ResultSet
    */
  def createTable(st: Statement): Int = st.executeUpdate(Querys.createTable)

  /**
    *
    * @param st receives an statement
    * @return a ResultSet
    */
  def getTables(st: Statement): ResultSet = st.executeQuery(Querys.showTables)

  /**
    *
    * @param st receives an statement
    * @return a ResultSet
    */
  def insertData(st: Statement): Int = st.executeUpdate(Querys.insertData)

  /**
    *
    * @param st receives an statement
    * @return a ResultSet
    */
  def getData(st: Statement): ResultSet = st.executeQuery(Querys.getData)

}
