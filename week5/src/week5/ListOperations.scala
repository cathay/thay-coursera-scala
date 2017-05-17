package week5

object ListOperations {
  
  def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n+1)
  
  def flatten[T](xs: List[T]) = xs match {
    case List(x) => List(x)
    case x :: ys => xs
  }
}