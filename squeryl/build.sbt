name := "squeryl"

organization := "com.mdialog"

version := "0.0.1"

scalaVersion := "2.9.1"

scalacOptions ++= Seq("-unchecked", "-deprecation")

parallelExecution := false

libraryDependencies  ++=  Seq(
  "org.squeryl" %% "squeryl" % "0.9.5-RC1",
  "postgresql" % "postgresql" % "8.4-701.jdbc4",
  "c3p0" % "c3p0" % "0.9.1.2"
)

