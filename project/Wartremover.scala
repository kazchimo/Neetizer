import wartremover.contrib.ContribWart
import wartremover.{Wart, Warts}

object Wartremover {
  val wartErrors: Seq[Wart] = Warts.allBut(
    Wart.Nothing,
    Wart.Any,
    Wart.ImplicitConversion,
    Wart.ImplicitParameter,
    Wart.Product
  ) ++ ContribWart.allBut(
    ContribWart.SymbolicName,
    ContribWart.MissingOverride,
    ContribWart.Apply,
    ContribWart.NoNeedForMonad
  )
}
