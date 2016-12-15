package com.clouway.guice.modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class FireballModule extends AbstractModule {

  protected void configure() {
    bind(Integer.class).annotatedWith(Names.named("minFireball")).toInstance(2);
    bind(Integer.class).annotatedWith(Names.named("maxFireball")).toInstance(3);
  }
}
