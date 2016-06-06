package example.domain

import slick.driver.SQLiteDriver.api._
import slick.lifted._

case class Department(id:Long, name:String)

class Departments(tag:Tag)
    extends Table[Department](tag, "departments") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def * = (id, name) <> (Department.tupled, Department.unapply)
}
