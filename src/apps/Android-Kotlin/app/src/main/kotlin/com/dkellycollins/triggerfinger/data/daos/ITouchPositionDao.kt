package com.dkellycollins.triggerfinger.data.daos

import com.dkellycollins.triggerfinger.data.model.IVector

/**
 * Provides the ability to retrieve touch data.
 */
interface ITouchPositionDao {
    val lastPosition: IVector
    val isTouching: Boolean
}
