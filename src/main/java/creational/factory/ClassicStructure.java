package creational.factory;

public class ClassicStructure {

    static sealed interface Transport permits Car, Boat, Airplane {
        void move();
    }

    static final class Car implements Transport {
        @Override
        public void move() {
            System.out.println("Car move");
        }
    }
    
    static final class Boat implements Transport {
        @Override
        public void move() {
            System.out.println("Boat move");
        }
    }
    
    static final class Airplane implements Transport {
        @Override
        public void move() {
            System.out.println("Airplane move");
        }
    }

//    --- total 8 classes

    static abstract class TransportFactory {
        abstract Transport createTransport();
    }

    static class CarFactory extends TransportFactory {
        @Override
        Transport createTransport() {
            return new Car();
        }
    }

    static class BoatFactory extends TransportFactory {
        @Override
        Transport createTransport() {
            return new Boat();
        }
    }

    static class AirplaneFactory extends TransportFactory {
        @Override
        Transport createTransport() {
            return new Airplane();
        }
    }
}
