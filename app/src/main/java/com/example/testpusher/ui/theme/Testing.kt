package com.example.testpusher.ui.theme

fun main() {
    val first = mutableListOf(1, 5, 6, 3, 2, 9, 7)
    val findPrime = arrayListOf(3, 4, 5, 6, 7, 8, 11, 15, 16, 18, 17)
    filterListInAscending(first)

    val replaced = replaceSpacesWithStars("ABC 123 ZYX FAX")

    val isEven = getEven(4)

    println("Replace:->$replaced  \nIsEven:-> $isEven")
    for (number in findPrime) {
        if (printPrimes(number)) {
            println("Prime Number -> $number")
        }
    }
}

fun filterListInAscending(first: MutableList<Int>): MutableList<Int> {
    var swiped: Boolean
    do {
        swiped = false
        for (i in 1 until first.size) {
            if (first[i - 1] > first[i]) {
                val mTemp = first[i]  // storing the value
                first[i] = first[i - 1] // swipe the value
                first[i - 1] = mTemp   // then we replace the value at i-1 position
                swiped = true
            }
        }
    } while (swiped)
    println("Final $first")
    return first
}

fun replaceSpacesWithStars(input: String): String {
    return input.map {
        if (it == ' ') "*" else it
    }.joinToString("")
}

fun getEven(num: Int): Boolean {
    return num % 2 == 0
}

fun printPrimes(numb: Int): Boolean {
    for (i in 2 until numb) {
        if (numb % 2 == 0) {
            return false
        }
    }
    return true
}

