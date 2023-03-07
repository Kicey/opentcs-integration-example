package site.kicey.kernel.extensions.eventsender;

import java.util.logging.Logger;
import org.opentcs.customizations.kernel.KernelInjectionModule;

public class HelloModule extends KernelInjectionModule {

  Logger log = Logger.getLogger(HelloModule.class.getName());

  @Override
  protected void configure() {
  }
}
