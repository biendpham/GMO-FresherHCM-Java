/*
 * create Thread Safe Singleton class
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.creational.singleton;

public class ThreadSafeSingleton {
	
	private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
