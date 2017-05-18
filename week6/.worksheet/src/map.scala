object map {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 
  val capitalOfCountry = Map("US" -> "Washington","Switzerland" ->"Bern");System.out.println("""capitalOfCountry  : scala.collection.immutable.Map[String,String] = """ + $show(capitalOfCountry ));$skip(28); val res$0 = 
  
  capitalOfCountry("US");System.out.println("""res0: String = """ + $show(res$0));$skip(33); val res$1 = 
  capitalOfCountry get "andorra";System.out.println("""res1: Option[String] = """ + $show(res$1));$skip(28); val res$2 = 
  capitalOfCountry get "US";System.out.println("""res2: Option[String] = """ + $show(res$2));$skip(60); 
  
  val cap1 = capitalOfCountry withDefaultValue "Unknown";System.out.println("""cap1  : scala.collection.immutable.Map[String,String] = """ + $show(cap1 ));$skip(59); 
  
  val fruits = List("apple","pear","orange","pineable");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(39); val res$3 = 
  fruits sortWith(_.length < _.length);System.out.println("""res3: List[String] = """ + $show(res$3));$skip(35); val res$4 = 
  fruits.sortWith(_.head > _.head);System.out.println("""res4: List[String] = """ + $show(res$4));$skip(16); val res$5 = 
  fruits.sorted;System.out.println("""res5: List[String] = """ + $show(res$5));$skip(26); val res$6 = 
  fruits groupBy (_.head);System.out.println("""res6: scala.collection.immutable.Map[Char,List[String]] = """ + $show(res$6))}
}
