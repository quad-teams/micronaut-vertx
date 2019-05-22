package team.quad.labs;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;

import javax.inject.Inject;

@Factory
public class EventBusFactory {

  @Inject
  private Vertx vertx;

  @Bean
  public EventBus eventBus() {
    return vertx.eventBus();
  }
}
