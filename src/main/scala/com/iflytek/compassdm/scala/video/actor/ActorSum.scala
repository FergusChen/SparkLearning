package com.iflytek.compassdm.scala.video.actor


import scala.actors.Actor._ //需要引入scala-actors包

/**
 * Created by Administrator on 2016/11/3.
 */
object ActorSum {
  def main(args: Array[String]) {
    val a = 90
//    sum1(a)
    sum2(a)
  }
  def sum(n:Int):Int={
    if(n > 1) sum(n - 1) + n else 1
  }

  def sum1(n:Int) = {
    n to n + 10 foreach( i => println(sum(i)))
  }

  def sum2(n:Int) = {
    n to n + 10 foreach (i => actor {
      react { case n: Int => println(sum(n)) }
    })
  }


}
