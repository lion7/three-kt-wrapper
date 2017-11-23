@file:JsQualifier("THREE")

package info.laht.threekt.math

open external class Plane {

    constructor()
    constructor(normal: Vector3, constant: Double)

    var normal: Vector3
    var constant: Double

    fun set(normal: Vector3, constant: Number)

    fun clone() : Plane
    fun copy(plane: Plane) : Plane

}

