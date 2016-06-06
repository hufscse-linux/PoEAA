package example.domain

import slick.driver.SQLiteDriver.api._
import slick.lifted._

case class Student(id:Long, name:String, departmentId:Long)

class Students(tag: Tag)
    extends Table[Student](tag, "students") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def departmentId = column[Long]("department_id")
  def * = (id, name, departmentId) <> (Student.tupled, Student.unapply)
  //def department = foreignKey("department_fk", departmentId)(_.id)
}
