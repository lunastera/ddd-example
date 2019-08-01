package com.github.sobreera.domain.repository

import java.sql.Connection

import com.github.sobreera.domain.model.user.{User, UserId}
import com.github.sobreera.infrastructure.db.model.UserRecord
import com.github.sobreera.infrastructure.db.query.UserQuery
import scalikejdbc._

import scala.util.Try

class UserRepository {
  def query(implicit conn: Connection) = UserQuery(DB(conn))

  def convertToEntity(record: UserRecord): User =
    User(
      UserId(record.id),
      record.name,
      record.password
    )

  def resolveByUserId(userId: String)(implicit conn: Connection): Try[Option[User]] = Try {
    query.findById(userId).map(convertToEntity)
  }
}
