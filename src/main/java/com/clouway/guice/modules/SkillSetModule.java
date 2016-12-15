package com.clouway.guice.modules;

import com.clouway.core.implementations.Fireball;
import com.clouway.core.implementations.Frostbolt;
import com.clouway.core.interfaces.Skill;
import com.clouway.guice.providers.SkillSetProvider;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

import java.util.Set;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class SkillSetModule extends AbstractModule {
  protected void configure() {
    Multibinder<Skill> multibinder = Multibinder.newSetBinder(binder(),Skill.class);
    multibinder.addBinding().to(Fireball.class).asEagerSingleton();
    multibinder.addBinding().to(Frostbolt.class);

    bind(Set.class).toProvider(SkillSetProvider.class);
  }
}
