package week4

abstract class Boolean1 {
	def ifThenElse[T](t: => T, e: => T) : T
	
	def && (x: => Boolean1): Boolean1 = ifThenElse(x, false1)
}

object true1 extends Boolean1 {
	def ifThenElse[T] (t: => T, e: => T) = t
}

object false1 extends Boolean1 {
  def ifThenElse[T] (t: => T, e: => T) = e
}