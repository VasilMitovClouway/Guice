package com.clouway.core.implementations;

import com.clouway.core.annotations.CriticalAnnounce;
import com.clouway.core.interfaces.Character;
import com.clouway.core.interfaces.Skill;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.Random;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class SwordAttack implements Skill {
  private final Integer minDamage;
  private final Integer maxDamage;
  private Random random=new Random();

  @Inject
  public SwordAttack(@Named("minSwordAttack") Integer minDamage,@Named("maxSwordAttack") Integer maxDamage) {
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
  }

  public void cast(Character target) {
    Random random = new Random();
    Integer damage = random.nextInt((maxDamage - minDamage) + 1) + minDamage;
    Integer chance=random.nextInt(4);
    //Any from 1-4 is ok here, simulating a chance roll.
    if (chance.equals(1)){
      target.decreaseHp(criticalChance(damage));
    }
    target.decreaseHp(damage);
  }

  public String name() {
    return "Sword Attack";
  }

  @CriticalAnnounce
  public Integer criticalChance(Integer damage){
    return damage*2;
  }
}
