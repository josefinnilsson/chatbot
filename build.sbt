name := """chatbot"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(SbtWeb, PlayJava, PlayEbean, PlayAkkaHttpServer)
  .disablePlugins(PlayNettyServer)


scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  evolutions
)
libraryDependencies += "org.apache.lucene" % "lucene-core" % "6.4.0"
libraryDependencies += "org.elasticsearch" % "elasticsearch" % "5.2.0"
libraryDependencies += "org.elasticsearch.client" % "transport" % "5.2.0"
libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.8.1"
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.8.1"

fork in run := true
