package com.github.sobreera.domain.support

import scalikejdbc.DB

case class EntityIOContextOnJDBC(db: DB) extends EntityIOContext
