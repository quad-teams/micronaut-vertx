package team.quad.labs;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.reactivex.Single;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;

import javax.inject.Inject;

@Controller
public class EchoController {

  @Inject
  private EventBus eventBus;

  @Get("/echo")
  public Single<String> send(@QueryValue String message) {
    return Single.create(emitter -> {
      eventBus.<String>send("echo", message, handler -> {
        Message<String> answer = handler.result();
        emitter.onSuccess(answer.body());
      });
    });
  }
}
