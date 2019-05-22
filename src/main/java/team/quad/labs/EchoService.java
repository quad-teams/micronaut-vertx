package team.quad.labs;

import io.micronaut.context.annotation.Context;
import io.vertx.core.eventbus.EventBus;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Context
public class EchoService {

  @Inject
  private EventBus eventBus;

  @PostConstruct
  public void register() {
    eventBus.consumer("echo", message ->
      message.reply(message.body()));
  }
}
