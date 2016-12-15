package com.clouway.guice.modules;

import com.clouway.core.interfaces.Armor;
import com.clouway.core.annotations.ObsidianPlate;
import com.clouway.core.implementations.ObsidianPlateArmor;
import com.clouway.core.annotations.Plate;
import com.clouway.core.implementations.PlateArmor;
import com.clouway.core.interfaces.Skill;
import com.clouway.guice.providers.SkillProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class CharacterModule extends AbstractModule {

  protected void configure() {
    bind(Integer.class).annotatedWith(Names.named("hpVillian")).toInstance(10);
    bind(Integer.class).annotatedWith(Names.named("hpHero")).toInstance(8);
    bind(Skill.class).toProvider(SkillProvider.class);
  }

  @Provides
  @ObsidianPlate
  public Armor getObsidianArmor() {
    return new ObsidianPlateArmor(2);
  }

  @Provides
  @Plate
  public Armor getPlateArmor() {
    return new PlateArmor(1);
  }

}