object pair_of_prime {

  def makePair(n: Int) = (1 until n) flatMap (i => (1 until i) map (j => (i, j)))
                                                  //> makePair: (n: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]

  def isPrime(n: Int) = (2 until n) forall (n % _ != 0)
                                                  //> isPrime: (n: Int)Boolean
  
  makePair(4)                                     //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2))
  makePair(7) filter (pair => isPrime(pair._1 + pair._2))
                                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  
  val n=7                                         //> n  : Int = 7
  
  for {
  	i <- 1 to n
  	j <- 1 to i
  	
  	if isPrime(i +j)
  } yield (i,j)                                   //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (2,1
                                                  //| ), (3,2), (4,1), (4,3), (5,2), (6,1), (6,5), (7,4), (7,6))
        
  def scalarProduct(xs: List[Double], ys:List[Double]): Double =
   (for	{(x,y) <- (xs zip ys) } yield x*y).sum    //> scalarProduct: (xs: List[Double], ys: List[Double])Double
  
}