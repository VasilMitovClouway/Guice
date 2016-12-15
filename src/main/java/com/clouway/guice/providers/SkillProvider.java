package com.clouway.guice.providers;

import com.clouway.core.interfaces.Skill;
import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.Map;
import java.util.Random;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class SkillProvider implements Provider<Skill> {

  private final Random random;
  private final Map<Integer,Skill> mapBinder;

  @Inject
  public SkillProvider(Random random, Map<Integer, Skill> mapBinder) {
    this.random = random;
    this.mapBinder = mapBinder;
  }

  public Skill get() {
    return mapBinder.get(random.nextInt(mapBinder.size()));
  }
}