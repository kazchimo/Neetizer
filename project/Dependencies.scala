import sbt._

object Dependencies {
  object Version {
    lazy val Zio = "1.0.4.1"
  }

  object Org {
    lazy val Zio = "dev.zio"
  }

  object Deps {
    lazy val Zio: Seq[ModuleID] = Seq("zio", "zio-streams", "zio-macros").map(Org.Zio %% _ % Version.Zio)

    lazy val all: Seq[ModuleID] = Zio
  }
}
