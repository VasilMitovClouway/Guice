package com.clouway.guice.modules;

import com.clouway.core.annotations.FireballSound;
import com.clouway.guice.interceptor.FireballCastEffectInterceptor;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class FireballCastEffectModule extends AbstractModule {

  protected void configure() {
    bindInterceptor(Matchers.any(),Matchers.annotatedWith(FireballSound.class),new FireballCastEffectInterceptor());
  }
}
