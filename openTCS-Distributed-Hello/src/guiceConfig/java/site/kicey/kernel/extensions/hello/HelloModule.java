package site.kicey.kernel.extensions.hello;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;
import org.opentcs.customizations.kernel.KernelInjectionModule;

public class HelloModule extends KernelInjectionModule {

  Logger log = Logger.getLogger(HelloModule.class.getName());

  @Override
  protected void configure() {
    Runnable hello = () -> log.info("Hello World!");
    ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(1);
    scheduledService.scheduleAtFixedRate(hello, 0, 1, java.util.concurrent.TimeUnit.SECONDS);
  }
}
