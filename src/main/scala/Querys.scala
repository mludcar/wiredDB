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
  val insertData = "INSERT INTO test_schema.test_table VALUES " +
                   "(1, 'El Quijote', 'Miguel de Cervantes')," +
                   "(2, 'Dune', 'Frank Herbert')," +
                   "(3, 'El Senor de los anillos', 'JRR Tolkien')," +
                   "(4, 'Ensayo sobre la ceguera', 'Jose Saramago')," +
                   "(5, 'Bored To Death', 'Neil Postman')," +
                   "(6, 'Juego de Tronos', 'George R Martin')," +
                   "(7, 'El Capitan Alatriste', 'Arturo Perez Reverte')"
  val getData = "SELECT * FROM test_schema.test_table"

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
