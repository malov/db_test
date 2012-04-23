name := "circumflex"

organization := "com.mdialog"

version := "0.0.1"

scalaVersion := "2.9.1"

scalacOptions ++= Seq("-unchecked", "-deprecation")

parallelExecution := false

libraryDependencies ++= Seq(
  "ru.circumflex" % "circumflex-orm" % "2.1" % "compile->default"
)
