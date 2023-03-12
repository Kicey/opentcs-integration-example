package top.more.position;

import org.opentcs.customizations.kernel.KernelInjectionModule;


public class PositionModule extends KernelInjectionModule {
  @Override
  protected void configure() {

    extensionsBinderOperating().addBinding()
        .to(VehiclePositionPrinter.class);
  }
}
