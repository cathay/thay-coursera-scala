object experiment {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(43); 
  val s = "Hello World"
  
  import forcomp.Anagrams._;System.out.println("""s  : String = """ + $show(s ));$skip(99); val res$0 = 
  s.trim().toLowerCase().groupBy(identity).mapValues(_.size).toList;System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(59); 
  
  val groups = s.trim().toLowerCase().groupBy(identity);System.out.println("""groups  : scala.collection.immutable.Map[Char,String] = """ + $show(groups ));$skip(27); val res$1 = 
  groups.mapValues(_.size);System.out.println("""res1: scala.collection.immutable.Map[Char,Int] = """ + $show(res$1));$skip(46); val res$2 = 
  groups.map( pair => (pair._1,pair._2.size));System.out.println("""res2: scala.collection.immutable.Map[Char,Int] = """ + $show(res$2));$skip(69); 
  val wordOcurrences = groups.map{ case (c,w) => (c,w.size) }.toList;System.out.println("""wordOcurrences  : List[(Char, Int)] = """ + $show(wordOcurrences ));$skip(24); val res$3 = 
  wordOcurrences.sorted;System.out.println("""res3: List[(Char, Int)] = """ + $show(res$3));$skip(16); val res$4 = 
  
  s.mkString;System.out.println("""res4: String = """ + $show(res$4));$skip(30); val res$5 = 
  wordOccurrences(s mkString);System.out.println("""res5: forcomp.Anagrams.Occurrences = """ + $show(res$5));$skip(116); 
  def fold(arr: Array[(Char,Int)]) = {
  	arr.foldLeft('0',0){case ((acc1,acc2), (a1,a2) ) => (acc1,acc2 + a2)}
  };System.out.println("""fold: (arr: Array[(Char, Int)])(Char, Int)""");$skip(37); val res$6 = 
  
  s.toLowerCase().groupBy(c => c);System.out.println("""res6: scala.collection.immutable.Map[Char,String] = """ + $show(res$6));$skip(74); 
  val temp = s.split(" +").flatMap(w => wordOccurrences(w)).groupBy(_._1);System.out.println("""temp  : scala.collection.immutable.Map[Char,Array[(Char, Int)]] = """ + $show(temp ));$skip(68); val res$7 = 
  //The stupid version
  temp.map{ case (c,arr) => (c, fold(arr)) };System.out.println("""res7: scala.collection.immutable.Map[Char,(Char, Int)] = """ + $show(res$7));$skip(59); 
  
  val words = List("abbot", "abbots", "Abbott","Abbot");System.out.println("""words  : List[String] = """ + $show(words ));$skip(102); val res$8 = 
  
  words map (c => (c,wordOccurrences(c))) groupBy(_._2) mapValues(values => values map(v => v._1));System.out.println("""res8: scala.collection.immutable.Map[forcomp.Anagrams.Occurrences,List[String]] = """ + $show(res$8));$skip(43); val res$9 = 
  
 combinations(List(('a', 2), ('b', 2)));System.out.println("""res9: List[forcomp.Anagrams.Occurrences] = """ + $show(res$9));$skip(25); val res$10 = 
 dictionaryByOccurrences;System.out.println("""res10: Map[forcomp.Anagrams.Occurrences,List[forcomp.Anagrams.Word]] = """ + $show(res$10));$skip(57); val res$11 = 
  dictionaryByOccurrences getOrElse (List(('e',1)), Nil);System.out.println("""res11: List[forcomp.Anagrams.Word] = """ + $show(res$11));$skip(98); 
  
  
  val occurs = List(('e',1), ('i',1), ('l',3), ('n',1), ('r',1), ('u',2), ('x',1), ('z',1));System.out.println("""occurs  : List[(Char, Int)] = """ + $show(occurs ));$skip(231); 
                                                  
  def subtract2(x: Occurrences, y: Occurrences) = y.foldLeft(x) {
   (acc,eY) =>
  	for(eX <- acc) yield (eX._1, if (eX._1 == eY._1) eX._2 - eY._2 else eX._2)
  }.filter(_._2 > 0);System.out.println("""subtract2: (x: forcomp.Anagrams.Occurrences, y: forcomp.Anagrams.Occurrences)List[(Char, Int)]""");$skip(58); val res$12 = 
  subtract2(occurs, List(('e',1),('i',1),('l',1))).sorted;System.out.println("""res12: List[(Char, Int)] = """ + $show(res$12));$skip(221); val res$13 = 
  //combinations(occurs) filter dictionaryByOccurrences.contains
  for{
  
  	combi <- combinations(occurs) filter dictionaryByOccurrences.contains
  	word <- dictionaryByOccurrences getOrElse (combi, Nil)
  } yield word;System.out.println("""res13: List[forcomp.Anagrams.Word] = """ + $show(res$13))}
  //import forcomp._
  //loadDictionary
}
