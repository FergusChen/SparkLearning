package com.iflytek.compassdm.video

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Administrator on 2016/10/31.
 */
abstract class IntQueue {

  def get():Int
  def put(x:Int)
}

class BasicIntQueue extends IntQueue{
  private val buf = new ArrayBuffer[Int]()
  def get() = buf.remove(0)
  def put(x:Int) {buf += x}
}

/**
 * 继承自抽象类的特质
 * */
trait Incrementing extends IntQueue{
  abstract override def put(x:Int): Unit ={
    super.put(x + 1)
  }
}

trait Doubling extends IntQueue{
  abstract override def put(x:Int): Unit ={
    super.put(x * 2)
  }
}

/**测试，特质的顺序，从右往左*/
object TestClient extends App{
  val queue1 = new BasicIntQueue with Incrementing with Doubling
  queue1.put(2)  //先做Doubling，再做Incrementing
  println(queue1.get()) //output：5

  val queue2 = new BasicIntQueue with Doubling with Incrementing
  queue2.put(2)  //先做Incrementing，再做Doubling
  println(queue2.get())  //output：6


}


