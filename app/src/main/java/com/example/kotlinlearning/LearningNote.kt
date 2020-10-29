package com.example.kotlinlearning

/**第二章 基础语法**/

//fun main() {
//  val a = 3
//    println(sum1(4, 7))
//}
/**
 * ❑ 程序中最基本的操作，如声明变量、定义函数以及字符串操作；
 * ❑ 高阶函数的概念，以及函数作为参数和返回值的作用；
 * ❑ Lambda表达式语法，以及用它来简化程序表达；
 * ❑ 表达式在Kotlin中的特殊设计，以及if、when、try等表达式的用法。
 */

//2.1 不一样的类型声明
val a: String = "I am Kotlin!"
    //2.1.1 增强的类型推导
        // 类型推导是Kotlin在Java基础上增强的语言特性之一
    //2.1.2 声明函数返回值类型（不可省略）
fun sum(x: Int,y: Int):Int{
  return x+y
}
    //当函数无返回值类型时，返回为Unit对象===>Void
    //表达式函数体->"=" = 单行表达式
fun sum1(x: Int, y: Int) = x + y
        //在某些复杂情况下，表达式函数体也需指明返回类型，比如递归
fun recursion(x: Int): Int = if(x == 1) 1 else x * recursion(x-1)
    //代码块函数体->普通函数体
fun sum2(x:Int, y:Int){
  println(x + y)
}

// 2.2 val与var的使用规则
    //val 定义常量;var 定义变量
    // 2.2.1 val的含义：引用不可变
        //可以修改val引用对象的值，但不可修改应用对象
    // 2.2.2 优先使用val来避免副作用
        // 因为引用不可变，val声明的变量只能被赋值一次，且在声明时不能省略变量类型
        // 副作用的产生往往与可变数据及共享状态有关，有时候它会使得结果变得难以预测。
        // val只能确保变量引用的不可变
    // 2.2.3 var的适用场景
        // 有更好的性能，占用内存更少。需要存储大量的数据,采用var是其更加适合。

// 2.3 高阶函数和Lambda
    // 函数式语言->把函数当作为一个对象处理
//fun main() {
//    val value = test(10)
//    println(value)//101
//}

fun test(y: Int): Int{
    fun double(y: Int)= y * y
    return  double(y) + 1
}
    // 2.3.1 抽象和高阶函数
        // 高阶函数：用其他函数作为参数和返回值的函数
    // 2.3.2 实例：函数作为参数的需求
        // 1. 函数必须有参数类型
        // 2. 函数的引用作为参数被传递
    // 2.3.3 函数的类型
        // 函数的声明： <函数形参名称> : ([[参数1名称:]参数1],[[参数1名称:]参数2][?])-> <返回值类型>
        // 注：[]：可有可无；<>：必须有; ? :可以为空
    // 2.3.4 方法和成员的引用
        // 引用object实例的method -> object::method
        // 引用object实例的variable -> object::variable

//    fun main() {
//        val numbs = listOf(1,4,7,12,14,15)
//        val filter = Filter()
//        val check = CheckUtil()
//        filter.filtrateNum(numbs, check::isGreaterThanTen)
//    }

    class Filter{

        fun filtrateNum(listNum:List<Int>, checkMethod:(Int)->Boolean){
                for (i in listNum) {
                    if(checkMethod(i)){
                        println(i)
                    }
                }
            }
        }

    class CheckUtil{
        fun isGreaterThanTen(x: Int) = x > 10
    }

    // 2.3.5 匿名函数(不需要该函数命名，直接将函数的实现作为形参)
//    fun main() {
//        val numbs = listOf(1,4,7,12,14,15)
//        val filter = Filter()
//        filter.filtrateNum(numbs, fun (x:Int):Boolean{return x % 2 == 0})
//        filter.filtrateNum(numbs, fun (x:Int):Boolean{return x % 3 == 0})
//    }
    // 2.3.6 Lambda是语法糖
        // 2.3.5中提到的匿名函数就是Lambda表达式
    fun main() {
        val numbs = listOf(1,4,7,12,14,15)
        val filter = Filter()
        filter.filtrateNum(numbs) { x -> x % 2 == 0}
        val sum = fun (x:Int, y:Int):Int{return x + y}
        println("sum ==> " + sum(1,4))
        //Lambda函数
        val sum1:(Int, Int) -> Int = {x :Int, y :Int -> x + y}
        println("sum1 ===> " + sum1(3,4))
        //简化1：
        val sum2:(Int, Int) -> Int={x ,y -> x+y}
        println("sum2 ===> " + sum2(4,5))
        //简化2：
        val sum3={x:Int, y:Int -> x + y}
        println("sum3 ===> " + sum3(6,5))
    }
        


