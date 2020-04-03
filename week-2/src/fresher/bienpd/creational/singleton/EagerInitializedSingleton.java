/*
 * Create Eager Initialized Singleton class
 *
 * @author BienPD
 *
 */
package fresher.bienpd.creational.singleton;

public class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    private EagerInitializedSingleton(){}
    
    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}
