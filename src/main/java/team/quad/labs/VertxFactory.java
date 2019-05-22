package team.quad.labs;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.vertx.core.Vertx;

@Factory
public class VertxFactory {

  @Bean
  public Vertx get() {
    return Vertx.vertx();
  }
}
