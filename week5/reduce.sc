object reduce {
 
  def sum(xs: List[Int]) = (0 :: xs) reduceLeft (_ + _)
                                                  //> sum: (xs: List[Int])Int
 	def product(xs: List[Int]) = (1 :: xs) reduceLeft (_ * _)
                                                  //> product: (xs: List[Int])Int
 
 def sumFold(xs: List[Int]) = (xs foldLeft 0) (_ + _)
                                                  //> sumFold: (xs: List[Int])Int
                                                  
 def concat[T](xs: List[T], ys: List[T]): List[T] =
 	(xs foldLeft ys) (_ :+ _)                 //> concat: [T](xs: List[T], ys: List[T])List[T]
 	
 	def concat1[T](xs: List[T], ys: List[T]): List[T] =
 	(xs foldRight ys) (_ :: _)                //> concat1: [T](xs: List[T], ys: List[T])List[T]
 	
 	def mapFun[T,U](xs:List[T], f: T => U): List[U] =
 		(xs foldRight List[U]()) (f(_) :: _)
                                                  //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
 	def lengthFun[T](xs:List[T]): Int =
 		(xs foldRight 0) ((x,y) => 1 + y )//> lengthFun: [T](xs: List[T])Int
 		
 	val l1 = List(1,2,3)                      //> l1  : List[Int] = List(1, 2, 3)
 	val l2 = List(4,5,6)                      //> l2  : List[Int] = List(4, 5, 6)
 	
 	concat(l1,l2)                             //> res0: List[Int] = List(4, 5, 6, 1, 2, 3)
 	concat1(l1,l2)                            //> res1: List[Int] = List(1, 2, 3, 4, 5, 6)
 	
 	1 +: List(2,3) :+4                        //> res2: List[Int] = List(1, 2, 3, 4)
}