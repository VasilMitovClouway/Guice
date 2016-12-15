package com.clouway.core.implementations;

import com.clouway.core.annotations.Plate;
import com.clouway.core.interfaces.Armor;
import com.clouway.core.interfaces.Character;
import com.clouway.core.interfaces.Skill;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;


/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class HeroCharacter implements Character {
  private Integer hp;
  private final Armor armor;
  private final Skill skill;
  private Character target = null;


  @Inject
  public HeroCharacter(@Named("hpHero") Integer hp, @Plate Armor armor, Provider<Skill> skill) {
    this.hp = hp;
    this.armor = armor;
    this.skill = skill.get();
  }

  public void target(Character target) {
    this.target = target;
  }

  public String action() {
    skill.cast(target);
    return "Hero attacked with " + skill.name();
  }

  public void decreaseHp(Integer damage) {
    hp -= armor.resistDamage(damage);
  }

  public String status() {
    if (isDead()) {
      return "Hero is dead";
    }
    return "Hero:" + hp + "hp";
  }

  public boolean isDead() {
    if (hp<=0){
      return true;
    }
    return false;
  }

}
