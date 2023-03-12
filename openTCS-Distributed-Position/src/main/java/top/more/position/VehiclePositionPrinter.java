package top.more.position;

import org.opentcs.components.kernel.KernelExtension;
import org.opentcs.components.kernel.services.VehicleService;
import org.opentcs.data.model.Vehicle;

import javax.inject.Inject;
import java.util.logging.Logger;

public class VehiclePositionPrinter implements KernelExtension {
  private final VehicleService vehicleService;

  Logger log = Logger.getLogger(VehiclePositionPrinter.class.getName());
  @Inject
  public VehiclePositionPrinter(VehicleService vehicleService){
    this.vehicleService = vehicleService;
  }
  @Override
  public void initialize() {
    log.info("++++PointerPosition++++");
    Runnable position = () -> {
      for (;;){
        try {
          Thread.sleep(1000);
          for (Vehicle vehicle : vehicleService.fetchObjects(Vehicle.class)) {
            log.info("=?=?=?=?= Vehicle " + vehicle.getName() + " is at " + vehicle.getCurrentPosition()+"=?=?=?=?=");
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };
    Thread t = new Thread(position);
    t.start();

  }

  @Override
  public boolean isInitialized() {
    return false;
  }

  @Override
  public void terminate() {

  }
}
