package example.domain

import org.scalatest._
import slick.driver.SQLiteDriver.api._
import scala.concurrent.ExecutionContext.Implicits.global

class StudentSpec extends FlatSpec {

  "Student" should "have department" in {
    val database = Database.forURL(
      "jdbc:sqlite:university.sqlite3",
      driver = "org.sqlite.JDBC"
    )
    try {
      val students = TableQuery[Students]
      val departments = TableQuery[Departments]

      student.department = foreignKey("department_fk", student.departmentId, departments);

      students join department on(_.departmentId === _.id)

    } finally database.close
  }

}
