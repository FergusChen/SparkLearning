package com.iflytek.compassdm.scala.book.basic

import scala.collection.mutable.ArrayBuffer
/**
 * Created by Administrator on 2016/11/14.
 * 不可变长度：Array， 可变长度：ArrayBuffer
 * 如果有初始值，不要用new
 * for(elem <- arr)遍历
 * for(elem <- arr if...) yield... 生成新的数组
 *
 */
object ArrayDemo {
  def main(args: Array[String]) {

    val arr1 = new Array[Int](10) //new关键字必须指定类型，确定长度
    val arr2 = Array(2, 11, 13, 3, 5, 7, 17)

    /** 下标查找，结尾添加删除元素都是很高效，但是中间添加元素会导致元素逐个右移。因此，有insert和remove的实现，但并不推荐*/
    val arr3 = ArrayBuffer[Int]()
    arr3 += 2
    arr3 += (3, 5, 7, 11)
    arr3 ++= Array(13, 17, 19)
    arr3.trimEnd(3)  //删除末尾的3个元素

    arr3.insert(2, 5) //数组位置2插入元素5
    arr3.insert(2, 5, 6, 7) //数组位置2插入元素5， 6， 7
    arr3.remove(2)  //移除位置2的元素
    arr3.remove(2, 3)  //移除位置2开始的3个元素。

    val arrayBuff1 = arr1.toBuffer
    val bufferArr1 = arr3.toArray

    for( i <- ( 0 until arr3.length).reverse){
      println(i + ": " +arr3(i) )
    }

    for( i <- 0 until (arr3.length, 2)){ //给遍历添加步长
      println(i + ": " +arr3(i) )
    }

    val res1 = for( elem <- arr3) yield elem * 2
    println(res1)

    val res2 = for(elem <- arr3 if elem % 2 == 0) yield elem * 2

    val res3 = arr3.filter(_ % 2 == 0).map(_ * 2)  //等价于for + 守卫 + yield。 只是不同的风格

    val arr4 = ArrayBuffer[Int](1, 5, -1 ,20, 24, -3, 10, -10, -5, 4)
    println("arr4: " + arr4)
    val arr5 = removeNagetiveExceptFirst(arr4)
    println("arr5: " + arr5)

    val sum = arr3.sum
    val max = arr3.max
    val sortedArr1 = arr4.sortWith(_ < _)
    scala.util.Sorting.quickSort(arr2)  //只能针对Array，不能针对ArrayBuffer，排序结果仍保存在arr2
    val arrayStr1 = arr3.mkString(",")
    val arrayStr2 = arr3.mkString("<" , "," , ">") // output: <1, 2, 3...>

    /**多维数组*/
    val matrix = Array.ofDim[Double](4, 5)  //4 * 5的矩阵
    matrix(1)(2) = 20
    //不规则的多维数组
    val triangle = new Array[Array[Int]](5)
    for(i <- 0 until triangle.length){
      triangle(i) = new Array[Int](i + 1)
    }

    /**这里用到的scala和java数组的转化*/
    import scala.collection.JavaConversions._

    val javaList:java.util.List[Int] = ArrayBuffer(1, 2, 3)  //将scala的ArrayBuffer转化为java的List，是通过scala的包装类来实现的
    val scalaSeq:Seq[Int] = javaList    //也是隐式转换，将java的List转换为scala的seq
//    val command = ArrayBuffer("ls", "-al", "/home/cay")
//    val pb = new ProcessBuilder(command)
//
//    val cmd: Buffer[String] = pb.command()

  }

  /**
   * 删除数组中除第1个负数之外的所有负数。
   * */
  def removeNagetiveExceptFirst(array: ArrayBuffer[Int]):ArrayBuffer[Int] = {
    var first = true
    //记录所有非负数和第1个负数的索引
    val indexes = for(i <- 0 until array.length if first || array(i) >= 0) yield{
      if(array(i) < 0) first = false
      i
    }

    for(i <- 0 until indexes.length){
      array(i) = array(indexes(i))
    }

    array.trimEnd(array.length - indexes.length)

    array
  }

}
