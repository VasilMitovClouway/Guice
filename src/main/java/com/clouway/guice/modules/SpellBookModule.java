package com.clouway.guice.modules;

import com.clouway.core.implementations.SwordAttack;
import com.clouway.core.interfaces.Skill;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class SpellBookModule extends AbstractModule {
  protected void configure() {
    Multibinder<Skill> multibinder = Multibinder.newSetBinder(binder(), Skill.class);
    multibinder.addBinding().to(SwordAttack.class);

  }
}
