object map {
  val capitalOfCountry = Map("US" -> "Washington","Switzerland" ->"Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US ->
                                                  //|  Washington, Switzerland -> Bern)
  
  capitalOfCountry("US")                          //> res0: String = Washington
  capitalOfCountry get "andorra"                  //> res1: Option[String] = None
  capitalOfCountry get "US"                       //> res2: Option[String] = Some(Washington)
  
  val cap1 = capitalOfCountry withDefaultValue "Unknown"
                                                  //> cap1  : scala.collection.immutable.Map[String,String] = Map(US -> Washington
                                                  //| , Switzerland -> Bern)
  
  val fruits = List("apple","pear","orange","pineable")
                                                  //> fruits  : List[String] = List(apple, pear, orange, pineable)
  fruits sortWith(_.length < _.length)            //> res3: List[String] = List(pear, apple, orange, pineable)
  fruits.sortWith(_.head > _.head)                //> res4: List[String] = List(pear, pineable, orange, apple)
  fruits.sorted                                   //> res5: List[String] = List(apple, orange, pear, pineable)
  fruits groupBy (_.head)                         //> res6: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineable), a -> List(apple), o -> List(orange))
}