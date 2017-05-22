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
  
  val words = List("abbot", "abbots", "Abbott","Abbot")
                                                  //> words  : List[String] = List(abbot, abbots, Abbott, Abbot)
  
  words map (c => (c,wordOccurrences(c))) groupBy(_._2) mapValues(values => values map(v => v._1))
                                                  //> res8: scala.collection.immutable.Map[forcomp.Anagrams.Occurrences,List[Strin
                                                  //| g]] = Map(List((a,1), (b,2), (o,1), (t,1)) -> List(abbot, Abbot), List((a,1)
                                                  //| , (b,2), (o,1), (t,2)) -> List(Abbott), List((a,1), (b,2), (o,1), (s,1), (t,
                                                  //| 1)) -> List(abbots))
  
 combinations(List(('a', 2), ('b', 2)))           //> res9: List[forcomp.Anagrams.Occurrences] = List(List(), List((a,1)), List((a
                                                  //| ,2)), List((b,1)), List((a,1), (b,1)), List((a,2), (b,1)), List((b,2)), List
                                                  //| ((a,1), (b,2)), List((a,2), (b,2)))
 dictionaryByOccurrences                          //> res10: Map[forcomp.Anagrams.Occurrences,List[forcomp.Anagrams.Word]] = Map(L
                                                  //| ist((e,1), (i,1), (l,1), (r,1), (t,2)) -> List(litter), List((a,1), (d,1), (
                                                  //| e,1), (g,2), (l,1), (r,1)) -> List(gargled), List((a,1), (e,1), (h,1), (i,1)
                                                  //| , (k,1), (n,1), (s,3)) -> List(shakiness), List((e,2), (g,1), (n,1)) -> List
                                                  //| (gene), List((a,2), (n,1), (t,1), (y,1)) -> List(Tanya), List((a,1), (d,1), 
                                                  //| (e,2), (h,1), (m,1), (n,2), (o,1), (s,3)) -> List(handsomeness), List((a,2),
                                                  //|  (c,1), (e,2), (k,1), (l,1), (m,1), (p,1), (r,1), (t,1)) -> List(marketplace
                                                  //| ), List((a,1), (i,1), (l,2), (s,1), (v,1)) -> List(villas), List((d,2), (e,1
                                                  //| ), (h,2), (n,1), (r,1), (t,1), (u,1)) -> List(hundredth), List((a,3), (b,1),
                                                  //|  (c,1), (h,1), (i,2), (l,1), (o,1), (p,2), (r,1), (t,1), (y,1)) -> List(appr
                                                  //| oachability), List((d,1), (e,2), (l,1), (s,1), (t,2)) -> List(settled), List
                                                  //| ((a,1), (g,1), (i,3), (l,1), (n,2), (t,1), (z,1)) -> List(Latinizing), List(
                                                  //| (a,1), (m,1), (n,1), (o,
                                                  //| Output exceeds cutoff limit.
  dictionaryByOccurrences getOrElse (List(('e',1)), Nil)
                                                  //> res11: List[forcomp.Anagrams.Word] = List()
  
  
  val occurs = List(('e',1), ('i',1), ('l',3), ('n',1), ('r',1), ('u',2), ('x',1), ('z',1))
                                                  //> occurs  : List[(Char, Int)] = List((e,1), (i,1), (l,3), (n,1), (r,1), (u,2)
                                                  //| , (x,1), (z,1))
                                                  
  def subtract2(x: Occurrences, y: Occurrences) = y.foldLeft(x) {
   (acc,eY) =>
  	for(eX <- acc) yield (eX._1, if (eX._1 == eY._1) eX._2 - eY._2 else eX._2)
  }.filter(_._2 > 0)                              //> subtract2: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrence
                                                  //| s)List[(Char, Int)]
  subtract2(occurs, List(('e',1),('i',1),('l',1))).sorted
                                                  //> res12: List[(Char, Int)] = List((l,2), (n,1), (r,1), (u,2), (x,1), (z,1))
  //combinations(occurs) filter dictionaryByOccurrences.contains
  for{
  
  	combi <- combinations(occurs) filter dictionaryByOccurrences.contains
  	word <- dictionaryByOccurrences getOrElse (combi, Nil)
  } yield word                                    //> res13: List[forcomp.Anagrams.Word] = List(Eli, lie, ill, en, in, Len, Lin, 
                                                  //| nil, lien, line, Neil, Nile, Nell, re, ire, rill, rein, liner, lieu, lull, 
                                                  //| nu, null, rue, Uri, lure, rule, run, urn, ruin, urine, ex, Rex, Unix, Linux
                                                  //| , Liz, Zen, Uzi, rulez, Zulu)
  //import forcomp._
  //loadDictionary
}