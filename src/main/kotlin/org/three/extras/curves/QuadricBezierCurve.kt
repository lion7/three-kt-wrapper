@file:JsQualifier("THREE")

package org.three.extras.curves

import org.three.extras.core.Curve
import org.three.math.Vector2

open external class QuadricBezierCurve : Curve<Vector2> {

    constructor(v0: Vector2 = definedExternally,
                v1: Vector2 = definedExternally,
                v2: Vector2 = definedExternally)

    override fun clone() : QuadricBezierCurve
    fun copy(curve: QuadricBezierCurve3) : QuadricBezierCurve

}

