package models

import com.websudos.phantom.dsl._

import scala.concurrent.Future

/**
  * Created by root on 16. 9. 29.
  */
case class Account(
                  email:String,
                  name:String,
                  passwd:String
                  )
abstract class Accounters extends CassandraTable[ConcreteAccounters, Account]{
    object email extends StringColumn(this) with PrimaryKey[String]
    object name extends StringColumn(this)
    object passwd extends StringColumn(this) with Index[String]

  def fromRow(row:Row):Account = {
     Account(
       email = email(row),
       name = name(row),
       passwd = passwd(row)
     )
  }
}

abstract class ConcreteAccounters extends Accounters with RootConnector{
  def getByEmail(Email: String, Passwd: String): Future[Option[Long]] = {
    select.count.where(_.email eqs Email).and(_.passwd eqs Passwd).one
  }

  /*def getByPasswd(Passwd: String): Future[Option[Account]] = {
    val result = select.where(_.passwd eqs Passwd).one()
    result
  }*/
}
