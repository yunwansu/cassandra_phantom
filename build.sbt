name := """cassandra_phantom_0"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

val PhantomVersion = "1.22.0"

resolvers ++= Seq(
  "Typesafe repository snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
  "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype repo"                    at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype releases"                at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots"               at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype staging"                 at "http://oss.sonatype.org/content/repositories/staging",
  "Java.net Maven2 Repository"       at "http://download.java.net/maven/2/",
  "Twitter Repository"               at "http://maven.twttr.com",
  Resolver.bintrayRepo("websudos", "oss-releases")
)

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.websudos" % "phantom-dsl_2.11" % "1.28.14",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

