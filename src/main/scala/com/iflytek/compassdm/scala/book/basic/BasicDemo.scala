package com.iflytek.compassdm.scala.book.basic

/**
 * Created by Administrator on 2016/11/13.
 */
object BasicDemo {

  def main(args: Array[String]) {

    /**高级for循环*/
//    for(i <- 1 to 3; j <- 1 to 3) print( (10 * i + j) + " ")  //11 12 13 21 22 23 31 32 33
//    for(i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")  //加入守卫；12 13 21 23 31 32
//    for(i <- 1 to 3; from = 4 - i; j <- from to 3) print((10 * i + j) + " ") //引入变量；13 22 23 31 32 33
    val result = for(i <- 1 to 10) yield i % 3 //for推导式：yield构造集合，其类型和第1个生成器类型兼容
    println(result)  //Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
    val res1 = for(c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
    println(res1) //HIeflmlmop， 第1个生成器是字符串，结果也是字符串。
    val res2 = for(i <- 0 to 1; c <- "Hello") yield (c + i).toChar
    println(res2) //Vector(H, e, l, l, o, I, f, m, m, p)  第1个生成器是Range，结果也是Vector，类型兼容

    for{ i <- 1 to 3
    from = 4 - i
    j <- from to 3} print((10 * i + j) + " ") //将生成器和守卫都放在花括号中，不用分号，而是换行隔开。

    //调用可变长参数的函数
//    val res3 = sum(1 to 5) //这样的方法是不可行的
    val res3 = sum(1 to 5: _*) //将1 to 5当做参数，序列化处理
  }

  /**函数的定义  默认参数*/
  def decorate(str:String, left:String = "[", right: String = "]") = {
    left + str + right
  }

  /**函数的定义： 可变长参数*/
  def sum(args: Int*) = {
    var result = 0
    for(arg <- args) result += arg
    result
  }

  def recursiveSum(args: Int*) :Int = {
    if(args.length == 0) 0
    else args.head + recursiveSum(args.tail: _*)
  }


}
