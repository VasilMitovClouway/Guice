package com.clouway.core.implementations;

import com.clouway.core.annotations.ObsidianPlate;
import com.clouway.core.interfaces.Armor;
import com.clouway.core.interfaces.Character;
import com.clouway.core.interfaces.Skill;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import java.util.Random;
import java.util.Set;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class VillianCharacter implements Character {

  private Integer hp;
  private final Armor armor;
  private final Set<Skill> skills;
  private Character target = null;
  private Random random = new Random();

  @Inject
  public VillianCharacter(@Named("hpVillian") Integer hp, @ObsidianPlate Armor armor, Set<Skill>skillSet) {
    this.hp = hp;
    this.armor = armor;
    this.skills = skillSet;
  }

  public void target(Character target) {
    this.target = target;
  }

  public String action() {
    Integer randmSkillIndex = random.nextInt(skills.size());
    Integer iterator = 0;
    Skill castedSkill = null;
    for (Skill skill : skills) {
      if (iterator.equals(randmSkillIndex)) {
        castedSkill = skill;
        skill.cast(target);
      }
      iterator++;
    }
    return "Villian Attacked with " + castedSkill.name();
  }

  public void decreaseHp(Integer damage) {
    hp -= armor.resistDamage(damage);
  }

  public String status() {
    if (isDead()) {
      return "Villian is dead";
    }
    return "Villian:" + hp + "hp";
  }

  public boolean isDead() {
    if (hp <= 0) {
      return true;
    }
    return false;
  }
}
