package com.iflytek.compassdm.scala.video.function

/**
 * Created by Administrator on 2016/11/1.
 *
 * 偏函数使用模式匹配来定义。通常也可以应用于参数，根据参数判断，参数的不同类型可以执行不同的语句
 */

object PartialFunctionDemo {
  
  val getNum:PartialFunction[Int, String] ={
    case 1 => "one"
    case 2 => "two"
  }

  getNum.isDefinedAt(1) //=> true
  getNum.isDefinedAt(3) // => false



}
