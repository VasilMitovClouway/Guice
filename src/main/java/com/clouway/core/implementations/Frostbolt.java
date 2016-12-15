package com.clouway.core.implementations;

import com.clouway.core.interfaces.Character;
import com.clouway.core.interfaces.Skill;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class Frostbolt implements Skill {
  private final Integer damage;


  @Inject
  public Frostbolt(@Named("frostboltDamage") Integer damage) {
    this.damage = damage;
  }

  public void cast(Character target) {
    target.decreaseHp(damage);
  }

  public String name() {
    return "Frostbolt";
  }
}
