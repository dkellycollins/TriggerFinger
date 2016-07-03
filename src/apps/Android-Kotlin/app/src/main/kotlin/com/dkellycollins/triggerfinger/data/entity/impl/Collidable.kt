package com.dkellycollins.triggerfinger.data.entity.impl

import com.dkellycollins.triggerfinger.data.entity.ICollidable
import com.dkellycollins.triggerfinger.data.model.IVector
import com.dkellycollins.triggerfinger.data.model.impl.Vector2

import java.io.Serializable

class Collidable(override val id: Int, position: IVector, override var radius: Float) : ICollidable, Serializable {

    private val _position: Vector2

    init {

        _position = Vector2(position.x, position.y, 0f)
    }

    override var center: IVector
        get() = _position
        set(position) {
            _position.x = position.x
            _position.y = position.y
        }
}
