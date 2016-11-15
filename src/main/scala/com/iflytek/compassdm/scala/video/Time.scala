package com.iflytek.compassdm.video

/**
 * Created by Administrator on 2016/10/30.
 */
class Time (private var hours: Int, private var minutes:Int) {
  //warning 尚未实现getter和setter的重写，以进行校验
  def get() {
    println(hours + ": " + minutes)
  }

  def doAdd(){
    minutes += 1
    if(minutes == 60){
      minutes = 0
      hours += 1
      if(hours == 24){
        hours = 0
      }
    }
  }

}
