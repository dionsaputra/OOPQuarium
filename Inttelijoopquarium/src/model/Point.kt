package model

import kotlin.math.sqrt

data class Point(var x: Int = 0, var y: Int = 0) {

    fun distance(point: Point): Double {
        val dx = x - point.x
        val dy = y - point.y
        return sqrt(dx * dx + dy * dy.toDouble())
    }
}