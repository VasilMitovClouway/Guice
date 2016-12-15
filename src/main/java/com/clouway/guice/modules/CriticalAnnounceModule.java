package com.clouway.guice.modules;

import com.clouway.core.annotations.CriticalAnnounce;
import com.clouway.guice.interceptor.CriticalAnnounceInterceptor;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class CriticalAnnounceModule extends AbstractModule {
  protected void configure() {
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(CriticalAnnounce.class), new CriticalAnnounceInterceptor());
  }
}
