package creational.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModernStructure {

    sealed interface Transport permits Car, Boat, Airplane {
        void move();
    }

    static final class Car implements Transport {
        public void move() {
            System.out.println("Car");
        }
    }

    static final class Boat implements Transport {
        public void move() {
            System.out.println("Boat");
        }
    }

    static final class Airplane implements Transport {
        public void move() {
            System.out.println("Plane");
        }
    }

//    --- total 5 classes

    static class TransportFactory {

        public static final Map<String, Supplier<Transport>> TRANSPORT_MAP = new HashMap<>();

        static {
            TRANSPORT_MAP.put("CAR", Car::new);
            TRANSPORT_MAP.put("BOAT", Boat::new);
            TRANSPORT_MAP.put("AIRPLANE", Airplane::new);
            // todo default?
        }

        public static Transport createTransport(String type) {
            Supplier<Transport> supplier = TRANSPORT_MAP.get(type.toUpperCase());
            if (supplier == null) throw new IllegalArgumentException("Unknown Transport type: " + type);
            return supplier.get();
        }

    }

}
