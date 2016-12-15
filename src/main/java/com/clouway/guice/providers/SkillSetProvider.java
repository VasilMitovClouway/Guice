package com.clouway.guice.providers;

import com.clouway.core.interfaces.Skill;
import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.Set;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class SkillSetProvider implements Provider<Set<Skill>> {
  private final Set<Skill> skills;

  @Inject
  public SkillSetProvider(Set<Skill> skills) {
    this.skills = skills;
  }

  public Set<Skill> get() {
    return skills;
  }
}
