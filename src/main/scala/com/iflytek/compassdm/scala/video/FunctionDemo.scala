package com.iflytek.compassdm.scala.video

/**
 * Created by Administrator on 2016/10/31.
 */
object FunctionDemo {


  /**头等函数
    * 这里将函数f作为参数传入到函数sum中，函数f是从Int到Int的函数。
    * */
  def sum(f:Int=>Int, a:Int, b:Int):Int={
    if(a > b) 0 else f(a) + sum(f, a+1, b)
  }

  def f1(a:Int) = a
  def sum1(a:Int, b:Int):Int = sum(f1, a, b)

  def f2(a:Int) = a * 2
  def sum2(a:Int, b:Int):Int = sum(f2, a, b)

  /**匿名函数
    * 匿名函数常常作为参数使用，其作用范围仅在于调用的函数体内
    * */
  (x:Int) => x * 2

  def sum3(a:Int,b:Int):Int = sum((x:Int) => x, a, b)

  /** 高阶函数， TODO
    * 用函数生成函数
    * */

//  val f3 = (a:Int) => a * 3
//  def mul(a:Int) = (b:Int) => b * a  //mul输入为整型，返回为1个函数
//  val f3 = mul(3)
//  def sum4(f:Int => Int) = (a:Int, b: Int) => Int = {
//    def sum5(a:Int, b:Int):Int = sum(f, a, b)
//    sum5
//  }

  /** 柯里化
    * 柯里化是指将接受两个参数的函数变成新的接受1个参数的函数
    * */
  // 将mul函数进行柯里化
  // def mul(a:Int, b:Int) =  a * b
  // 柯里化如下：
  def mul(a:Int)(b:Int) = a * b
  //柯里化是将这个函数变成了两个函数：
  // first输入1个参数，返回1个函数；second输入1
  // def first(a:Int) = (b:Int) => a * b
  // def second = first(a)

  //对如下函数进行柯里化：
//  def A(a:Int, b:Double, c:Int, d:String) = println(a + b + c + d)
  def A(a:Int)(b:Double)(c:Int)(d:String) = println(a + b + c + d)
  //def A = (a:Int) => (b:Double) => (c:Int) => (d:String) => println(a + b + c + d)

}
