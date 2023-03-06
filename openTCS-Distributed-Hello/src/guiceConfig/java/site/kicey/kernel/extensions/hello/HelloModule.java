package site.kicey.kernel.extensions.hello;

import java.util.logging.Logger;
import org.opentcs.customizations.kernel.KernelInjectionModule;

public class HelloModule extends KernelInjectionModule {

  Logger log = Logger.getLogger(HelloModule.class.getName());

  @Override
  protected void configure() {
    Runnable hello = () -> {
      for (;;){
        log.info("Hello World!");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
    Thread t = new Thread(hello);
    t.start();
  }
}
