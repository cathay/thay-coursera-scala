object experiment {
  val s = "Hello World"                           //> s  : String = Hello World
  
  import forcomp.Anagrams._
  s.trim().toLowerCase().groupBy(identity).mapValues(_.size).toList
                                                  //> res0: List[(Char, Int)] = List((e,1), ( ,1), (l,3), (h,1), (r,1), (w,1), (o,
                                                  //| 2), (d,1))
  
  val groups = s.trim().toLowerCase().groupBy(identity)
                                                  //> groups  : scala.collection.immutable.Map[Char,String] = Map(e -> e,   -> " "
                                                  //| , l -> lll, h -> h, r -> r, w -> w, o -> oo, d -> d)
  groups.mapValues(_.size)                        //> res1: scala.collection.immutable.Map[Char,Int] = Map(e -> 1,   -> 1, l -> 3,
                                                  //|  h -> 1, r -> 1, w -> 1, o -> 2, d -> 1)
  groups.map( pair => (pair._1,pair._2.size))     //> res2: scala.collection.immutable.Map[Char,Int] = Map(e -> 1,   -> 1, l -> 3,
                                                  //|  h -> 1, r -> 1, w -> 1, o -> 2, d -> 1)
  val wordOcurrences = groups.map{ case (c,w) => (c,w.size) }.toList
                                                  //> wordOcurrences  : List[(Char, Int)] = List((e,1), ( ,1), (l,3), (h,1), (r,1)
                                                  //| , (w,1), (o,2), (d,1))
  wordOcurrences.sorted                           //> res3: List[(Char, Int)] = List(( ,1), (d,1), (e,1), (h,1), (l,3), (o,2), (r,
                                                  //| 1), (w,1))
  
  s.mkString                                      //> res4: String = Hello World
  wordOccurrences(s mkString)                     //> res5: forcomp.Anagrams.Occurrences = List(( ,1), (d,1), (e,1), (h,1), (l,3),
                                                  //|  (o,2), (r,1), (w,1))
  def fold(arr: Array[(Char,Int)]) = {
  	arr.foldLeft('0',0){case ((acc1,acc2), (a1,a2) ) => (acc1,acc2 + a2)}
  }                                               //> fold: (arr: Array[(Char, Int)])(Char, Int)
  
  s.toLowerCase().groupBy(c => c)                 //> res6: scala.collection.immutable.Map[Char,String] = Map(e -> e,   -> " ", l 
                                                  //| -> lll, h -> h, r -> r, w -> w, o -> oo, d -> d)
  val temp = s.split(" +").flatMap(w => wordOccurrences(w)).groupBy(_._1)
                                                  //> temp  : scala.collection.immutable.Map[Char,Array[(Char, Int)]] = Map(e -> A
                                                  //| rray((e,1)), l -> Array((l,2), (l,1)), h -> Array((h,1)), r -> Array((r,1)),
                                                  //|  w -> Array((w,1)), o -> Array((o,1), (o,1)), d -> Array((d,1)))
  //The stupid version
  temp.map{ case (c,arr) => (c, fold(arr)) }      //> res7: scala.collection.immutable.Map[Char,(Char, Int)] = Map(e -> (0,1), l -
                                                  //| > (0,3), h -> (0,1), r -> (0,1), w -> (0,1), o -> (0,2), d -> (0,1))
  
 
  //import forcomp._
  //loadDictionary
}