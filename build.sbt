import Wartremover.wartErrors
import sbtwelcome.UsefulTask

ThisBuild / name := "Neetizer"
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "2.13.4"

ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.4.4"

lazy val Lint = config("lint").extend(Compile)

logo :=
  """
    | _   _           _   _
    || \ | | ___  ___| |_(_)_______ _ __
    ||  \| |/ _ \/ _ \ __| |_  / _ \ '__|
    || |\  |  __/  __/ |_| |/ /  __/ |
    ||_| \_|\___|\___|\__|_/___\___|_|
    |""".stripMargin

usefulTasks := Seq(
  UsefulTask("c", "compile", "Compile all modules"),
  UsefulTask("r", "reload", "Reload project"),
  UsefulTask("lint", "lint:compile", "Check lint by Wartremover")
)

inThisBuild(
  Seq(
    addCompilerPlugin(scalafixSemanticdb),
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    scalafixScalaBinaryVersion := "2.13"
  )
)

lazy val commonSetting = inConfig(Lint) {
  Defaults.compileSettings ++ wartremover.WartRemover.projectSettings ++
    Seq(
      sources in Lint := {
        val old = (sources in Lint).value
        old ++ (sources in Compile).value
      },
      wartremoverErrors := wartErrors
    )
}

lazy val root = project.in(file(".")).settings(commonSetting)
