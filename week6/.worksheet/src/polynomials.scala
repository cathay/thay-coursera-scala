object polynomials {
  class Poly(val terms0: Map[Int,Double]) {
  	
  	def this(bindings:(Int,Double)*) = this(bindings.toMap)
  	val terms =  terms0 withDefaultValue 0.0
  	
  	def + (other: Poly) = {
  		new Poly(terms ++ (other.terms map adjust))
  	}
  	
  	def adjust(term:(Int,Double)): (Int, Double) = {
  		val (exp,coeff) = term
  		exp -> (coeff +terms(exp))

  		//This code is obsolete with default value
  		/*
  		terms get exp match {
  			case Some(coeff1) =>  exp -> (coeff + coeff1)
  			case None => exp -> coeff
  		}*/
  	}
  	
  	//This version is faster than the above one because it does not need intermediate list creation
  	def +:(other:Poly) = {
  		new Poly((other.terms foldLeft terms)(addTerm))
  	}
  	
  	def addTerm(terms: Map[Int,Double], term: (Int,Double)): Map[Int,Double] = {
  		val (exp,coeff) = term
  		terms + (exp -> (coeff +terms(exp)))
  	}
  
  	override def toString = (for {(exp,coeff) <- terms.toList.sorted.reverse} yield coeff+"x^"+exp) mkString "+"
  }
  
  object Poly {
  	
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(1083); 
  
  val p1 = new Poly(1->2.0,3 -> 4.0, 5-> 6.2);System.out.println("""p1  : polynomials.Poly = """ + $show(p1 ));$skip(44); 
  val p2 = new Poly(Map(0-> 3.0, 3 -> 7.0));System.out.println("""p2  : polynomials.Poly = """ + $show(p2 ));$skip(10); val res$0 = 
  p1 + p2;System.out.println("""res0: polynomials.Poly = """ + $show(res$0));$skip(14); val res$1 = 
  
  p1 +: p2;System.out.println("""res1: polynomials.Poly = """ + $show(res$1))}
}
