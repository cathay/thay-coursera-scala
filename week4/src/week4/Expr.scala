package week4

trait Expr 
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Var(variable: String) extends Expr
case class Prod(e1: Expr, e2:Expr) extends Expr

object Prod {
  def apply(n: Int, e2:Expr): Prod = Prod(Number(n), e2)
}

object Sum {
  def apply(n: Int, e2:Expr): Sum = Sum(Number(n), e2)
}

object exprs {
  def show(e: Expr): String = e match {
    case Number(x) => x.toString
    case Sum(l,r) => show(l) + " + " + show(r)
    case Var(v) => v
    case Prod(l,r) => show(l) + " * " + show(r)
  }
}

object main {
  def main(args: Array[String]): Unit = {
    import exprs._
    println(show(Sum(Prod(2,Var("x")), Var("y"))))
    println(show(Prod(Sum(2,Var("x")), Var("y"))))
    
  }
}