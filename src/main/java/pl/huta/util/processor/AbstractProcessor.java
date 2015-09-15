package pl.huta.util.processor;

import pl.huta.util.processor.ScaleUnit.Scale;
import pl.huta.util.processor.ScaleUnit.ScaleLang;

public abstract class AbstractProcessor implements Processor {
    static protected final String SEPARATOR = " ";
    static protected final int NO_VALUE = -1;
	
    protected Scale scale = null;
    protected ScaleLang lang = null;
    
    public AbstractProcessor(Scale scale, ScaleLang lang) {
		this.scale = scale;
		this.lang = lang;
	}
    
	abstract public String getName(String number);
	
	public String getName(double number) {
        return getName(Double.toString(number));
	}

	public String getName(long number) {
        return getName(Long.toString(number));
	}

}
