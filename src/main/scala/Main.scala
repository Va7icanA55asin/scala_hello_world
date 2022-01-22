package com.github.va7icana55asin

import scala.io.StdIn.{readLine,readInt}

object Main extends App {
    println("----------------------------------Start----------------------------------")
    var test = ""
    val hello = "Hello"
    val world = "World"
    val exclaim = '!'
    test = s"$hello $world$exclaim"
    println(test)
    val multiline =
        """
          |This is a multiline string.
          |I can put a lot of text here and it will all be formatted correctly.
          |The syntax with the bars is a little odd but the IDE handles it so it's ok.
          |""".stripMargin
    println(multiline)

    println("Input something: ")
    val input = readLine()

    println(s"You wrote $input")

    var inputSecret = if (input equals("secret")) true else false

    if (inputSecret) println("Surprise!")

    println()

    println("Numbers!")
    val seq = Seq(1,2,3)

    for (num <- seq) {
        println(num)
    }

    println("Numbers another way:")
    seq.foreach(println)

    println("Embiggen the numbers I say!")
    val doubled = for (num <- seq) yield num * 2
    doubled.foreach(println)

    println("Input a number: ")
    var valid = false
    var numInput = 0

    // This errors saying the do is unexpected for some reason. Not sure why
//    do {
//        try {
//            numInput = readInt()
//            valid = true
//        } catch {
//            case e: NumberFormatException => println("That was not a number. Please try again")
//        }
//    } while (!valid)

    while (!valid) {
        try {
            numInput = readInt()
            valid = true
        } catch {
            case e: NumberFormatException => println("That was not a number. Please try again")
        }
    }

    numInput match {
        case x if x < 0 => println("That was a negative number")
        case 0 => println("That was a 0")
        case x if x % 2 == 0 => println("That was an even number")
        case x if x % 2 != 0 => println("That was an odd number")
        case _ => println("This shouldn't happen")
    }

    println("Test classes:")
    val testObj = new Test("testString", 2, 1.4)
    testObj.printVals()
    val testObj2 = new Test(test = "testString2", num = 2)
    testObj2.printVals()

    println("----------------------------------End-----------------------------------")
}

class Test(var test: String = "", val num: Int = 0, var dub: Double = 0.0) { //val makes it read only and the equals sets default values

    //Auxiliary two param constructor
    def this(test: String, num: Int) = {
        this(test, num, num)
    }

    def printVals(): Unit = println(s"The value of test is $test. The value of num is $num. The value of dub is $dub.")

    override def toString(): String = s"{test: $test, num: $num, dub: $dub}"
}