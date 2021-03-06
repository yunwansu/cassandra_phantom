package models

/**
  * Created by 완수세끼 on 2016-09-24.
  */
import com.websudos.phantom.dsl._

import scala.concurrent.Future


case class User(
                 id: String,
                 email: String,
                 name: String,
                 passwordHash: String,
                 salt: String,
                 registration: String
               )

abstract class Users extends CassandraTable[ConcreteUsers, User] {
  object id extends StringColumn(this) with PartitionKey[String]
  object email extends StringColumn(this)
  object name extends StringColumn(this)
  object passwordHash extends StringColumn(this)
  object salt extends StringColumn(this)
  object registration extends StringColumn(this)

  def fromRow(row: Row): User = {
    User(
      id = id(row),
      email = email(row),
      name = name(row),
      passwordHash = passwordHash(row),
      salt = salt(row),
      registration = registration(row)
    )
  }
}

abstract class ConcreteUsers extends Users with RootConnector {

  def store(user: User): Future[ResultSet] = {
    insert.value(_.id, user.id)
      .value(_.email, user.email)
      .value(_.name, user.name)
      .value(_.passwordHash, user.passwordHash)
      .value(_.salt, user.salt)
      .value(_.registration, user.registration)
      .future()
  }

  def creat(): Future[ResultSet] = {
    create
      .ifNotExists
      .future()
  }
  //def getById(id: UUID): Future[Option[User]] = {
    //select.where(_.id === id).one()
  //}

  //def deleteById(id: UUID): Future[ResultSet] = {
    //delete.where(_.id eqs id).future()
  //}
}