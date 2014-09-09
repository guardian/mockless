import sbtrelease._
import ReleaseStateTransformations._

releaseSettings

sonatypeSettings

organization := "com.gu"

name := "mockless"

scalaVersion := "2.11.2"

crossScalaVersions := Seq("2.10.4", "2.11.2")

libraryDependencies ++= Seq(
  if (scalaVersion.value == "2.11.2")
    "com.chuusai" %% s"shapeless" % "2.0.0"
  else
    "com.chuusai" % s"shapeless_${scalaVersion.value}" % "2.0.0",
  "org.specs2" %% "specs2" % "2.4.2" % "test"
)

description := "Mockless - make empty instances of your ADTs"

scmInfo := Some(ScmInfo(
  url("https://github.com/guardian/mockless"),
  "scm:git:git@github.com:guardian/mockless.git"
))

pomExtra := (
  <url>https://github.com/guardian/mockless</url>
    <developers>
      <developer>
        <id>robertberry</id>
        <name>Robert Berry</name>
        <url>https://github.com/robertberry</url>
      </developer>
    </developers>
  )

licenses := Seq("Apache V2" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

ReleaseKeys.crossBuild := true

ReleaseKeys.releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  ReleaseStep(
    action = state => Project.extract(state).runTask(PgpKeys.publishSigned, state)._1,
    enableCrossBuild = true
  ),
  setNextVersion,
  commitNextVersion,
  ReleaseStep(state => Project.extract(state).runTask(SonatypeKeys.sonatypeReleaseAll, state)._1),
  pushChanges
)
