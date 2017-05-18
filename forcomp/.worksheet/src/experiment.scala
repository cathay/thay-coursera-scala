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
  temp.map{ case (c,arr) => (c, fold(arr)) };System.out.println("""res7: scala.collection.immutable.Map[Char,(Char, Int)] = """ + $show(res$7))}
  
 
  //import forcomp._
  //loadDictionary
}
