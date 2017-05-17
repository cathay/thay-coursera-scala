object listfun {
  val nums = List(2,2, -5, 3, 8, 1)               //> nums  : List[Int] = List(2, 2, -5, 3, 8, 1)
  
  nums filter(_ > 0)                              //> res0: List[Int] = List(2, 2, 3, 8, 1)
  
  nums partition(_ > 0)                           //> res1: (List[Int], List[Int]) = (List(2, 2, 3, 8, 1),List(-5))
  
  nums takeWhile(_ > 0)                           //> res2: List[Int] = List(2, 2)
  nums dropWhile(_ > 0)                           //> res3: List[Int] = List(-5, 3, 8, 1)
  
  nums span (_ > 0)                               //> res4: (List[Int], List[Int]) = (List(2, 2),List(-5, 3, 8, 1))
  nums span (_ ==2)                               //> res5: (List[Int], List[Int]) = (List(2, 2),List(-5, 3, 8, 1))
 
 	def pack[T](xs: List[T]): List[List[T]] = xs match {
  	case Nil => Nil
  	case x :: ys =>  {
  		val (first, rest) = xs span(y => y == x)
  		first :: pack(rest)
  	}
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  def encode[T](xs: List[T]) = {
 		pack(xs) map(ys => (ys.head, ys.size))
 	}                                         //> encode: [T](xs: List[T])List[(T, Int)]
  
  val data = List("a","a","a","b","c","c","a")    //> data  : List[String] = List(a, a, a, b, c, c, a)
  pack(data)                                      //> res6: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))
                                                  //| 
  encode(data)                                    //> res7: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
}