package pl.huta.util.processor.english;

import pl.huta.util.processor.AbstractProcessor;
import pl.huta.util.processor.ScaleUnit.Scale;
import pl.huta.util.processor.ScaleUnit.ScaleLang;

/**
 * Created by huta on 31.08.15.
 */
public class DefaultProcessor extends AbstractProcessor {
    static private String MINUS = "minus";
    static private String UNION_AND = "and";

    static private String ZERO_TOKEN = "zero";

    private AbstractProcessor processor = null;
    
    public DefaultProcessor(Scale scale, ScaleLang lang) {
		super(scale, lang);
    	System.out.println(">>DefaultProcessor<<");
		processor = new CompositeBigProcessor(63, scale, lang);
	}

	@Override
    public String getName(String value) {
		System.out.println(String.format("Wywołuje dafault: %s ", value));
        boolean negative = false;
        if (value.startsWith("-")) {
            negative = true;
            value = value.substring(1);
        }

        int decimals = value.indexOf(".");
        String decimalValue = null;
        if (0 <= decimals) {
            decimalValue = value.substring(decimals + 1);
            value = value.substring(0, decimals);
        }

        String name = processor.getName(value);

        if (name.isEmpty()) {
            name = ZERO_TOKEN;
        } else if (negative) {
            name = MINUS.concat(SEPARATOR).concat(name);
        }

        if (!(null == decimalValue || decimalValue.isEmpty())) {
            name = name.concat(SEPARATOR).concat(UNION_AND).concat(SEPARATOR)
                    .concat(processor.getName(decimalValue))
                    .concat(SEPARATOR).concat(scale.getName(-decimalValue.length(), lang));
        }

        return name;
    }

}
