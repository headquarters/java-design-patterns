package singleton;

public class Singleton {

    // eagerly loaded
    // private static Singleton instance = new Singleton();

    // lazy loaded
    private static volatile Singleton instance = null;

    private Singleton() {
        // prevents reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
            // ensure thread safety
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
