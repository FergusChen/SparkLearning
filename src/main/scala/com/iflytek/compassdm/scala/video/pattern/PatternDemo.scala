package com.iflytek.compassdm.scala.video.pattern

/**
 * Created by Administrator on 2016/11/1.
 */
object PatternDemo {

  /**模式匹配多种类型
    * 这里要注意，List[String]、Map[Char,Int]等不会成功匹配。因为这些泛型具有特殊性，一般可以用List[_]来匹配
    * */
  def getType(a:Any){
    a match{
      case _:Array[Char] => println("Array[Char]")
      case _:Int => println("Int")
      case _:Char => println("Char")
      case _:List[_] => println("list")
      case _ => println("Error")
    }
  }




}
