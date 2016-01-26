name := """sample"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
//  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  //"org.specs2" %% "specs2-core" % "3.0" % "test"
  "org.scalaz" %% "scalaz-core" % "7.1.0"
 ,"org.typelevel" %% "scalaz-specs2" % "0.3.0" % "test"
)

//resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")


// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

