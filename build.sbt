//import AssemblyKeys._ 

//seq(assemblySettings: _*)

name := "vod_test"

organization := "com.mdialog"

version := "0.0.1"

scalaVersion := "2.9.1"

scalacOptions ++= Seq("-unchecked", "-deprecation")

parallelExecution := false

resolvers ++= Seq(
	"JBoss Repo" at "http://repository.jboss.org/nexus/content/groups/public",
	"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
//  "com.mdialog" %% "pb_library" % "1.2",
//	"com.mdialog" % "scala-hls_2.9.1" % "0.1",
//  "org.zeromq" %% "zeromq-scala-binding" % "0.0.5",
	"com.typesafe.akka" % "akka-actor" % "2.0.1",
	"com.google.protobuf" % "protobuf-java" % "2.4.1",
	"com.typesafe.akka" % "akka-testkit" % "2.0.1" % "test",
  "org.scalatest" %% "scalatest" % "1.7.1" % "test"
)

//excludeFilter in unmanagedResources := "mdialog.conf"

//test in assembly := {}

//excludedFiles in assembly <<= (excludedFiles in assembly) {
//    (old: Seq[File] => Seq[File]) => {
//        (bases: Seq[File]) =>
//            val mine = bases flatMap { base => (base / "reference.conf").get }
//            val theirs = old(bases)
//            mine ++ theirs
//    }
//}

//mainClass in assembly := Some("com.mdialog.linear_stream_manager.LinearStreamManager")
