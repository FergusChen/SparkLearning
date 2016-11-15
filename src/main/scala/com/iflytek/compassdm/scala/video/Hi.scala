package com.iflytek.compassdm.video

/**
 * Created by Administrator on 2016/10/31.
 */
object Hi {

  def main(args: Array[String]) {

  }

  trait one{
    def a()
  }

  trait two extends one {
    override def a(){
      print("My")
    }
    a
  }

  trait  three extends one{
    override def a(): Unit ={
      print("Name")
    }
    a
  }
  class Name() {
    val m = 1
  }
  val one = new Name() with two with three
  println()
  val two = new Name() with three with two
}
