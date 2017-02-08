package com.clouway.guice.modules;

import com.clouway.core.interfaces.Character;
import com.clouway.core.implementations.SoldierCharacter;
import com.clouway.core.implementations.VillianCharacter;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class DuelModule extends AbstractModule {
  protected void configure() {
    bind(Character.class).annotatedWith(Names.named("firstParticipant")).to(SoldierCharacter.class);
    bind(Character.class).annotatedWith(Names.named("secondParticipant")).to(VillianCharacter.class);
  }
}
