import sbt._

object Dependencies {

  def mainCore(scalaVersion: String) = Seq(
    "com.typesafe.slick" %% "slick" % "2.1.0-RC1",
    "joda-time" % "joda-time" % "2.3",
    "org.joda" % "joda-convert" % "1.6"
  )

  val testCore = Seq(
    "org.scalatest" %% "scalatest" % "2.2.0" % "test",
    "com.h2database" % "h2" % "1.4.180" % "test",
    "ch.qos.logback" % "logback-classic" % "1.1.2" % "test"
  )

  def core(scalaVersion: String) = mainCore(scalaVersion) ++ testCore

  val mainPlay = Seq(
    "com.typesafe.play" %% "play-slick" % "0.8.0-RC1"
  )

  val testPlay = Seq(
    "com.typesafe.play" %% "play-test" % "2.3.0" % "test"
  )

  val play = mainPlay ++ testPlay

}