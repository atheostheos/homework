public class App {

    public abstract class Animal {

        public abstract void feed(Animal animal);
    }

    public class Human extends Animal {

        public void feed(Dog dog) {

        }
    }

    public class Dog extends Animal {}
}
