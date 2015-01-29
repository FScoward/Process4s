name := "Process4s"

version := "1.0"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "org.eclipse.swt.win32.win32" % "x86" % "3.3.0-v3346",
  "joda-time" % "joda-time" % "2.3",
  "org.joda" % "joda-convert" % "1.6",
  "org.slf4j" % "slf4j-api" % "1.7.10",
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
)