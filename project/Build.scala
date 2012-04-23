import sbt._
import Keys._

object DBBuild extends Build {
    lazy val root = Project(id = "vod_test",
                            base = file(".")) aggregate(squeryl, circumflex)

    lazy val squeryl = Project(id = "squeryl",
                           base = file("squeryl"))

    lazy val circumflex = Project(id = "circumflex",
                           base = file("circumflex"))
}
