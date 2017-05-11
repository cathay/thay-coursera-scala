package week4

//Peano numbers
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  def isZero = true

  def +(that: Nat): Nat = that

  def -(that: Nat): Nat = if(that.isZero) this else throw new UnsupportedOperationException("Cannot - with 0")

  def predecessor: Nat = throw new UnsupportedOperationException("Cannot - with 0")

  def successor: Nat = new Succ(this)
  
}

class Succ(n: Nat) extends Nat {
  def isZero =  false
  def predecessor = n
  def successor = new Succ(this)
  
  def +(that: Nat) = new Succ(n + that)
  
  def -(that:Nat) = if(that.isZero) this else n - that.predecessor
}