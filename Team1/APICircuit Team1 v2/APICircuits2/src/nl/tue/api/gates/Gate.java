/**
 * 
 */
package nl.tue.api.gates;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author IMikovsk
 *
 */
public abstract class Gate<T> extends Observable {
	public static final String AND="AND";
	public static final String OR="OR";
	public static final String NOT="NOT";
	public static final String GTE="GTE";

	
	protected List<Gate<T>> inLinks = new ArrayList<>();
	public List<Gate<T>> getInLinks() {
		return inLinks;
	}
	
	public abstract T eval();
	public abstract String getType();
}
