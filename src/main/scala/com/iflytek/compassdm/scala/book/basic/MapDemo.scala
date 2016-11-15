package com.iflytek.compassdm.scala.book.basic

import scala.collection.mutable

/**
 * Created by Administrator on 2016/11/15.
 */
object MapDemo {

  def main(args: Array[String]) {

    val map1 = Map("Alice"-> 10, "Bob" -> 3, "Cindy" -> 4) //不可变映射
    val map2 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 4))

    val map3 = new mutable.HashMap[String, Int] //构造可变映射

    /**获取Map的值*/
    val bobsScore = map1("Bob")  //若是key不存在，则抛出异常
    val bobsScore2 = map1.get("Bob")  //返回Option对象， 要么是Some(Int), 要么是None
    val cindyScore = if (map1.contains("Cindy")) map1("Cindy") else 0
    val aliceScore = map1.getOrElse("Alice", 0)

    /**Map的更新*/
    map3("Fred") = 7 //只能针对可变Map，添加新的键值对
    map3 += ("Alice" -> 10, "Bob" -> 3)  //添加多个键值对
    map3 -= "Alice"  //删除键值对

    val newScores1 = map1 + ("Fred"-> 5, "Bob" -> 7)  //用不可变Map构造新的不可变Map，同时Bob的值被更新
    val newScores2 = map1 - "Alice"  //删除一个键值对



    val keys = map1.keySet
    val values = map1.values
    val res1 = for((k, v) <- map1) yield (v, k) //Map翻转

    /**Map的几种实现， 默认是HashMap，若要以key为顺序，则可以是SortedMap（树形映射，不可变）， 若要按插入顺序，则用LinkedHashMap*/
    val map4 = scala.collection.immutable.SortedMap(("Alice", 10), ("Cindy", 4), ("Bob", 3)) //会按照key进行排序
    //Map的遍历
    println("SortedMap: ")
    for((k, v) <- map4){
      println(k + ": " + v)
    }

    println("LinkedHashMap: ")
    val map5 = scala.collection.mutable.LinkedHashMap(("Alice", 10), ("Cindy", 4), ("Bob", 3))
    for((k, v) <- map5){
      println(k + ": " + v)
    }


  }
}
