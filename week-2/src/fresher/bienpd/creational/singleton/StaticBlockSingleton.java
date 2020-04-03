/*
 * create Static Block Singleton class
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.creational.singleton;

public class StaticBlockSingleton {
	
	private static StaticBlockSingleton instance;
    
    private StaticBlockSingleton(){}
    
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
