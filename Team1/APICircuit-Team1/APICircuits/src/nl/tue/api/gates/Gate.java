/**
 * 
 */
package nl.tue.api.gates;

/**
 * @author IMikovsk
 *
 */
public interface Gate {
	public static final String AND="AND";
	public static final String OR="OR";
	public static final String NOT="NOT";
	
	public Boolean eval();
	public String getType();
}
