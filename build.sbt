name := """chatbot"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(SbtWeb, PlayJava, PlayEbean, PlayAkkaHttpServer)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  evolutions,
    "org.apache.lucene"                     % "lucene-core"               % "6.4.0",
    "org.apache.lucene"                     % "lucene-queries"            % "6.4.0",
    "org.apache.lucene"                     % "lucene-queryparser"        % "6.4.0",
    "org.apache.lucene"                     % "lucene-suggest"            % "6.4.0",
    "org.apache.lucene"                     % "lucene-highlighter"        % "6.4.0",
    "org.apache.lucene"                     % "lucene-spatial-extras"     % "6.4.0",
    "org.apache.lucene"                     % "lucene-spatial3d"          % "6.4.0",
    "org.apache.lucene"                     % "lucene-spatial"            % "6.4.0",
    "org.apache.lucene"                     % "lucene-analyzers-common"   % "6.4.0",
    "org.apache.lucene"                     % "lucene-backward-codecs"    % "6.4.0",
    "org.apache.lucene"                     % "lucene-join"               % "6.4.0",
    "org.apache.lucene"                     % "lucene-memory"             % "6.4.0",
    "org.apache.lucene"                     % "lucene-misc"               % "6.4.0",
    "org.apache.lucene"                     % "lucene-sandbox"            % "6.4.0",
    "org.apache.lucene"                     % "lucene-join"               % "6.4.0",
    "org.elasticsearch.plugin"              % "transport-netty3-client"   % "5.2.0",
    "org.elasticsearch.plugin"              % "transport-netty4-client"   % "5.2.0",
    "org.elasticsearch.client"              % "transport"                 % "5.2.0",
    "org.elasticsearch.plugin"              % "reindex-client"            % "5.2.0",
    "org.elasticsearch.plugin"              % "lang-mustache-client"      % "5.2.0",
    "org.elasticsearch.plugin"              % "percolator-client"         % "5.2.0",
    "org.apache.logging.log4j"              % "log4j-api"                 % "2.7",
    "org.apache.logging.log4j"              % "log4j-core"                % "2.7",
    "org.apache.logging.log4j"              % "log4j-1.2-api"             % "2.7"
)

dependencyOverrides += "io.netty" % "netty-all" % "4.1.7.Final"
dependencyOverrides += "io.netty" % "netty-codec-http" % "4.1.7.Final"
dependencyOverrides += "io.netty" % "netty-handler" % "4.1.7.Final"
dependencyOverrides += "io.netty" % "netty-codec" % "4.1.7.Final"
dependencyOverrides += "io.netty" % "netty-transport" % "4.1.7.Final"
dependencyOverrides += "io.netty" % "netty-buffer" % "4.1.7.Final"
dependencyOverrides += "io.netty" % "netty-common" % "4.1.7.Final"
dependencyOverrides += "io.netty" % "netty-transport-native-epoll" % "4.1.7.Final"
dependencyOverrides += "io.netty" % "netty-resolver" % "4.1.7.Final"



fork in run := true
