package com.iflytek.compassdm.scala.video.pattern

/**
 * Created by Administrator on 2016/11/1.
 */
abstract class Expr {

  case class Number(n:Int)
  case class Sum(e1:Expr, e2:Expr)
  case class Mul(e1:Expr, e2:Expr)

//  def getFuncType(a:Expr):String = {
//    a match {
//      case Number(n) => "Number"
//      case Sum(e1, e2) => "Sum"
////      case _ => "Any" // 匹配任意，使用unchecked也可以避免使用_匹配全部
//    }
//  }


}
