package Tasks.step9.src;

/**
 * Session 9 - Extra task 2
 *
 *  For this task you are provided the following classes:
 *  - Car
 *  - Engine (abstract)
 *  -- ElectricEngine
 *  -- CombustionEngine
 *
 *  Create the following new classes:
 *  - Tesla
 *  - Toyota
 *  - Audi
 *
 *  They should all extend the Car class.
 *  For now, make sure they all properly extend the Car class, and
 *  then move on to the extra challenge below:
 *
 *  ---
 *
 *  Extra challenge:
 *
 *      Create two interfaces:
 *      - [ ] FuelBasedVehicle
 *      - [ ] ElectricBasedVehicle
 *
 *      Add a few methods which makes sense, for example ones that
 *      differentiate between fueling (combustion engine) and
 *      charging (electric engine) the car.
 *
 *      Adapt your Tesla, Toyota and Audi classes to use these interfaces respectively,
 *      based on the engine the car has.
 *
 *  ---
 *
 *  Extra-extra challenge:
 *
 *      Audi does for example have cars that run on either electricity or fuel,
 *      as in, based on the model of the car brand, it can have a different engine type.
 *
 *      In other words, not all Audi cars are fuel based (anymore).
 *
 *      How would you make changes to adapt your Audi class to take this into account?
 *      That based on the model of the car, the engine may differ.
 *
 */

public class Car {
    String name;
    String model;
    Engine engine;

    Car(String name, String model, boolean electric) {
        this.name = name;
        this.model = model;
        this.engine = electric ? new ElectricEngine() : new CombustionEngine();
    }
}

abstract class Engine {
    boolean electric;

    Engine(boolean electric) {
        this.electric = electric;
    }
}

class CombustionEngine extends Engine {
    CombustionEngine() {
        super(false);
    }
}

class ElectricEngine extends Engine {
    ElectricEngine() {
        super(true);
    }
}