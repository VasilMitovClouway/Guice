package com.clouway.guice.modules;

import com.clouway.core.implementations.Fireball;
import com.clouway.core.interfaces.Skill;
import com.clouway.core.implementations.SwordAttack;
import com.clouway.guice.providers.SkillProvider;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

import java.util.Random;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class SkillModule extends AbstractModule {

  protected void configure() {
    MapBinder<Integer, Skill> mapBinder = MapBinder.newMapBinder(binder(), Integer.class, Skill.class);

    mapBinder.addBinding(0).to(SwordAttack.class);

    bind(Random.class).toInstance(new Random());
    bind(Skill.class).toProvider(SkillProvider.class);
  }
}
