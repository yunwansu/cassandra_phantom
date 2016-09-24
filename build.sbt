name := """cassandra_phantom_0"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

val PhantomVersion = "1.28.14"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.websudos" % "phantom-dsl_2.11" % "1.28.14",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

resolvers ++= Seq(
  Resolver.typesafeRepo("releases"),
  Resolver.sonatypeRepo("releases"),
  Resolver.bintrayRepo("websudos", "oss-releases"),
  Resolver.jcenterRepo,
  "Twitter Repository" at "http://maven.twttr.com"
)