package com.dkellycollins.triggerfinger.managers.entity

import com.dkellycollins.triggerfinger.data.entity.IPlayer
import com.dkellycollins.triggerfinger.data.model.IVector

interface IPlayerEntityManager {

    fun retrieve(): Iterable<IPlayer>
    fun retrieve(playerId: Int): IPlayer
    fun retrievePlayerOne(): IPlayer

    fun create(position: IVector): Int

    fun update(playerId: Int, score: Int, health: Byte)

    fun delete(playerId: Int)
}
