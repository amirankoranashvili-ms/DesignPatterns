package structural.decorator;

public class Starbucks {

    public static void main(String[] args) {
        Espresso base =  new Espresso();
        Beverage custom = new Whip(new Mocha(new Mocha(base)));
        System.out.println(custom.description());
        System.out.println(custom.price());
    }

    interface Beverage {
        double price();

        String description();
    }

    static class Espresso implements Beverage {
        @Override
        public double price() {
            return 2.0;
        }

        @Override
        public String description() {
            return "Espresso";
        }
    }

    static class Mocha implements Beverage {

        static double ADDITIONAL_COST = 0.5;

        Beverage beverage;

        public Mocha(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public double price() {
            return beverage.price() + ADDITIONAL_COST;
        }

        @Override
        public String description() {
            return beverage.description() + " with " + "mocha";
        }
    }

    static class Whip implements Beverage {

        static double ADDITIONAL_COST = 0.3;

        Beverage beverage;

        public Whip(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public double price() {
            return beverage.price() + ADDITIONAL_COST;
        }

        @Override
        public String description() {
            return beverage.description() + " with " + "whip";
        }
    }

}
