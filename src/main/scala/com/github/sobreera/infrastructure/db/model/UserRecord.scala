package com.github.sobreera.infrastructure.db.model

import scalikejdbc._

case class UserRecord(id: String, name: String, password: String)

object UserRecord extends SQLSyntaxSupport[UserRecord] {
  override val tableName = "users"

  def apply(rs: WrappedResultSet): UserRecord = UserRecord(rs.string("id"), rs.string("name"), rs.string("password"))
  def apply(u: ResultName[UserRecord])(rs: WrappedResultSet): UserRecord = UserRecord(rs.string(u.id), rs.string(u.name), rs.string(u.password))
}