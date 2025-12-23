package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineService;

public class Application {

    private static VendingMachine vendingMachine;

    public static void main(String[] args) {
        VendingMachineService vendingMachineService = new VendingMachineService();
        VendingMachineController vendingMachineController = new VendingMachineController(vendingMachineService);
        vendingMachineController.run();
    }
}
