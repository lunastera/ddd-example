package com.github.sobreera.infrastructure.db.query

import com.github.sobreera.infrastructure.db.model.UserRecord
import scalikejdbc._
import scalikejdbc.DB

case class UserQuery(db: DB) {
  def findById(userId: String): Option[UserRecord] = {
    db.readOnly { implicit session =>
      val u = UserRecord.syntax("u")
      withSQL {
        select.from(UserRecord as u).where.eq(u.id, userId)
      }.map(UserRecord(_)).single().apply()
    }
  }
}
