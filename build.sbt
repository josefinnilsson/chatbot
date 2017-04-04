name := """chatbot"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(SbtWeb, PlayJava, PlayEbean)


scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  evolutions
)

libraryDependencies += "org.elasticsearch" % "elasticsearch" % "0.20.5"

fork in run := true
