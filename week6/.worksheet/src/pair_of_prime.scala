object pair_of_prime {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(105); 

  def makePair(n: Int) = (1 until n) flatMap (i => (1 until i) map (j => (i, j)));System.out.println("""makePair: (n: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]""");$skip(57); 

  def isPrime(n: Int) = (2 until n) forall (n % _ != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(17); val res$0 = 
  
  makePair(4);System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(58); val res$1 = 
  makePair(7) filter (pair => isPrime(pair._1 + pair._2));System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(13); 
  
  val n=7;System.out.println("""n  : Int = """ + $show(n ));$skip(81); val res$2 = 
  
  for {
  	i <- 1 to n
  	j <- 1 to i
  	
  	if isPrime(i +j)
  } yield (i,j);System.out.println("""res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$2));$skip(121); 
        
  def scalarProduct(xs: List[Double], ys:List[Double]): Double =
   (for	{(x,y) <- (xs zip ys) } yield x*y).sum;System.out.println("""scalarProduct: (xs: List[Double], ys: List[Double])Double""")}
  
}
