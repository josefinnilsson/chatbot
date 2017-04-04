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

libraryDependencies += "org.elasticsearch" % "elasticsearch" % "5.3.0"
libraryDependencies += "org.elasticsearch.client" % "transport" % "5.0.0"

fork in run := true
