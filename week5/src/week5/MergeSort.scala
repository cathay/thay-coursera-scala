package week5

import math.Ordering

object MergeSort {
  //  def merge[T](xs: List[T], ys: List[T])(lt: (T,T) => Boolean): List[T] = (xs, ys) match {
  //    case (Nil,ys) => ys
  //    case (xs, Nil) => xs
  //    case (x :: xTail, y :: yTail) => if (lt(x,y)) x :: merge(xTail, ys)(lt)  else y :: merge(xs, yTail)(lt)
  //  }
  //  
  //  def mergeSort[T](xs: List[T])(lt: (T,T) => Boolean): List[T] = {
  //    val n = xs.length /2
  //    if(n == 0) xs
  //    else {
  //      val (first, last) = xs splitAt n
  //      merge(mergeSort(first)(lt), mergeSort(last)(lt))(lt)
  //    } 
  //  }

  //Version with Ordering

  def merge[T](xs: List[T], ys: List[T])(implicit ord: Ordering[T]): List[T] = (xs, ys) match {
    case (Nil, ys)                => ys
    case (xs, Nil)                => xs
    case (x :: xTail, y :: yTail) => if (ord.lt(x, y)) x :: merge(xTail, ys) else y :: merge(xs, yTail)
  }

  def mergeSort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (first, last) = xs splitAt n
      merge(mergeSort(first), mergeSort(last))
    }
  }

  def main(args: Array[String]): Unit = {
    val nums = List(2, -5, 3, 8, 1)
    //println(mergeSort(nums)((x, y) => x < y))
    //non implicit
    println(mergeSort(nums)(Ordering.Int))

    println(mergeSort(nums))
  }
}