package site.kicey.kernel.extensions.eventsender;

import java.util.logging.Logger;
import org.opentcs.customizations.kernel.KernelInjectionModule;

public class EventSenderModule extends KernelInjectionModule {

  Logger log = Logger.getLogger(EventSenderModule.class.getName());

  @Override
  protected void configure() {
    extensionsBinderOperating()
        .addBinding().to(EventLogger.class);
  }
}
