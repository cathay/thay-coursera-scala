object boolean_implementation {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  println(false)                                  //> false
  import week4._
  true1 &&  true1                                 //> res0: week4.Boolean1 = week4.true1$@b684286
  true1 && false1                                 //> res1: week4.Boolean1 = week4.false1$@880ec60
  //println(true1 && true1)
 
  val intList = List(1,54,6,10,8,12,9)            //> intList  : List[Int] = List(1, 54, 6, 10, 8, 12, 9)
  import week4.InsertionSort._
  println(intList)                                //> List(1, 54, 6, 10, 8, 12, 9)
  println(isort(intList))                         //> List(1, 6, 8, 9, 10, 12, 54)
}