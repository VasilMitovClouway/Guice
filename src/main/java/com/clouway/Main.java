package com.clouway;

import com.clouway.core.Duel;
import com.clouway.guice.modules.CharacterModule;
import com.clouway.guice.modules.CriticalAnnounceModule;
import com.clouway.guice.modules.DuelModule;
import com.clouway.guice.modules.FireballCastEffectModule;
import com.clouway.guice.modules.FireballModule;
import com.clouway.guice.modules.SkillModule;
import com.clouway.guice.modules.SwordAttackModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(
            new SkillModule(),
            new CharacterModule(),
            new FireballModule(),
            new SwordAttackModule(),
            new FireballCastEffectModule(),
            new CriticalAnnounceModule(),
            new DuelModule());

    Duel duel = injector.getInstance(Duel.class);
    System.out.println(duel.start());
  }
}
