package creational.abstractfactory;

public class UITheme {

    // Entity interfaces
    interface Button {
        void render();
    }

    interface Toolbar {
        void render();
    }

    interface Background {
        void display();
    }

    // Concrete entities
    static class LightButton implements Button {
        @Override
        public void render() {
            System.out.println("LightButton");
        }
    }

    static class DarkButton implements Button {
        @Override
        public void render() {
            System.out.println("DarkButton");
        }
    }

    static class LightToolbar implements Toolbar {
        @Override
        public void render() {
            System.out.println("LightToolbar");
        }
    }

    static class DarkToolbar implements Toolbar {
        @Override
        public void render() {
            System.out.println("DarkToolbar");
        }
    }

    static class LightBackground implements Background {
        @Override
        public void display() {
            System.out.println("LightBackground");
        }
    }

    static class DarkBackground implements Background {
        @Override
        public void display() {
            System.out.println("DarkBackground");
        }
    }

    // Factories
    interface ThemeFactory {
        Button createButton();

        Toolbar createToolbar();

        Background createBackground();
    }

    static class LightThemeFactory implements ThemeFactory {
        @Override
        public Button createButton() {
            return new LightButton();
        }

        @Override
        public Toolbar createToolbar() {
            return new LightToolbar();
        }

        @Override
        public Background createBackground() {
            return new DarkBackground();
        }
    }

    static class DarkThemeFactory implements ThemeFactory {
        @Override
        public Button createButton() {
            return new DarkButton();
        }
        @Override
        public Toolbar createToolbar() {
            return new DarkToolbar();
        }
        @Override
        public Background createBackground() {
            return new LightBackground();
        }
    }

    // Usage
    static class GUI {
        private final Button button;
        private final Toolbar toolbar;
        private final Background background;

        public GUI(ThemeFactory tf) {
            button = tf.createButton();
            toolbar = tf.createToolbar();
            background = tf.createBackground();
        }

        public void render() {
            button.render();
            toolbar.render();
            background.display();
        }
    }

}
