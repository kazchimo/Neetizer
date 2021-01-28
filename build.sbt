import Wartremover.wartErrors

ThisBuild / name := "Neetizer"
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "2.13.4"

lazy val Lint = config("lint").extend(Compile)

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
