package com.clouway.core.interfaces;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public interface Character {

  void target(Character character);

  String action();

  void decreaseHp(Integer damage);

  String status();

  boolean isDead();

}
