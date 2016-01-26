/**
 * 
 */
package nl.tue.api.gates;

/**
 * @author IMikovsk
 *
 */
public class Not implements Gate{
	
	private Boolean input;
	private Boolean output;
	private static final String TYPE = Gate.NOT;

	@Override
	public Boolean eval() {
		output = !input;
		return output;
	}
	
	public Boolean getInput() {
		return input;
	}


	public void setInput(Boolean input) {
		this.input = input;
	}


	public Boolean getOutput() {
		return output;
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
