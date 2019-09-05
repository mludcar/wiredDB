/**
  *
  */
object Querys {
  val createSchema = "CREATE SCHEMA IF NOT EXISTS test_schema AUTHORIZATION sa;"
  val showSchemas = "SHOW SCHEMAS;"
  val createTable = "CREATE TABLE IF NOT EXISTS test_schema.test_table(" +
                    "id INT PRIMARY KEY NOT NULL," +
                    "title VARCHAR(50) NOT NULL," +
                    "author VARCHAR(20) NOT NULL," +
                    "   PRIMARY KEY(id)" +
                     ");"
  val showTables = "SHOW TABLES FROM test_schema;"
}

/**
  *
  */
object Configuration {
  val base = "tcp://localhost:9092"
  val url = "jdbc:h2:" + base + "/~/wiredDB"
  val driver = "org.h2.Driver"
  val username = "sa"
  val password = ""
}
