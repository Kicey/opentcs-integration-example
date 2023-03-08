package site.kicey.kernel.extensions.eventsender;

import com.google.inject.Inject;
import org.opentcs.components.kernel.KernelExtension;
import org.opentcs.customizations.ApplicationEventBus;
import org.opentcs.util.event.EventBus;
import org.opentcs.util.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventLogger implements EventHandler, KernelExtension {

  /**
   * This class's logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(EventLogger.class);

  @Inject
  public EventLogger( @ApplicationEventBus EventBus eventBus) {
    eventBus.subscribe(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void onEvent(Object event) {
    LOG.info("Received event: {}", event);
  }

  @Override
  public void initialize() {

  }

  @Override
  public boolean isInitialized() {
    return false;
  }

  @Override
  public void terminate() {

  }
}
