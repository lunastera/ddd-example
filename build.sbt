val ScalatraVersion = "2.7.0-RC1"

organization := "com.github.sobreera"

name := "LectureApp"

version := "0.0.1"

scalaVersion := "2.12.6"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.9.v20180320" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.scalikejdbc" %% "scalikejdbc"       % "3.3.5",
  "org.scalikejdbc" %% "scalikejdbc-config"  % "3.3.5",
  "com.h2database"  %  "h2"                % "1.4.199"
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
