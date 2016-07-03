package com.dkellycollins.triggerfinger.data.daos.impl

import com.dkellycollins.triggerfinger.data.daos.IPlayerDao
import com.dkellycollins.triggerfinger.data.entity.IPlayer
import com.dkellycollins.triggerfinger.data.entity.impl.Player

import java.util.HashMap

class PlayerDao : BaseEntityDao<Player>("PlayerDao"), IPlayerDao {

    private var _playerOne: Player? = null

    override fun create(collidableId: Int, invincibleTimerId: Int, weaponId: Int, score: Int, health: Byte): Int {
        val id = nextId
        val player = Player(id, collidableId, invincibleTimerId, weaponId, score, health)

        _store.put(id, player)
        if (_playerOne == null) {
            _playerOne = player
        }

        return id
    }

    override fun retrieve(): Iterable<IPlayer> {
        return _store.values
    }

    override fun retrieve(id: Int): IPlayer {
        if (!_store.containsKey(id)) {
            throw RuntimeException(String.format("Key {0} not found", id))
        }

        return _store[id]
    }

    override fun playerOne(): IPlayer {
        return _playerOne
    }

    override fun update(id: Int, weaponId: Int, score: Int, health: Byte) {
        if (!_store.containsKey(id)) {
            throw RuntimeException(String.format("Key {0} not found", id))
        }

        val player = _store[id]

        player.weaponId = weaponId
        player.score = score
        player.health = health
    }

    override fun delete(id: Int) {
        if (!_store.containsKey(id)) {
            throw RuntimeException(String.format("Key {0} not found", id))
        }

        _store.remove(id)
        if (_playerOne!!.id == id) {
            _playerOne = null
        }
    }
}
