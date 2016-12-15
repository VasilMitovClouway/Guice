package com.clouway.core.implementations;

import com.clouway.core.annotations.FireballSound;
import com.clouway.core.interfaces.Character;
import com.clouway.core.interfaces.Skill;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.Random;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class Fireball implements Skill {
  private final Integer minDamage;
  private final Integer maxDamage;


  @Inject
  public Fireball(@Named("minFireball") Integer minDamage, @Named("maxFireball") Integer maxDamage) {
    System.out.println("Fireball object is very eager to be created");
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
  }

  @FireballSound
  public void cast(Character target) {
    Random random = new Random();
    Integer damage = random.nextInt((maxDamage - minDamage) + 1) + minDamage;
    target.decreaseHp(damage);
  }

  public String name() {
    return "Fireball";
  }

}
