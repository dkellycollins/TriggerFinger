package com.dkellycollins.triggerfinger.data.entity;

public interface IPlayer extends IEntity {

    int getCollidableId();

    int getWeaponId();

    int getScore();

    byte getHealth();

    int getInvincibleTimerId();

}
