package pl.huta.util.processor.english;

import pl.huta.util.processor.AbstractProcessor;
import pl.huta.util.processor.ScaleUnit.Scale;
import pl.huta.util.processor.ScaleUnit.ScaleLang;

public class UnitProcessor extends AbstractProcessor {
    static private final String[] TOKENS = new String[] {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    public UnitProcessor(Scale scale, ScaleLang lang) {
    	super(scale, lang);
    	System.out.println(">>UnitProcessor<<");
    }
    
    @Override
    public String getName(String value) {
    	System.out.println(String.format("Wywołuje unit: %s ", value));
        StringBuilder buffer = new StringBuilder();

        int offset = NO_VALUE;
        int number;
        if (value.length() > 3) {
            number = Integer.valueOf(value.substring(value.length() - 3), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }
        number %= 100;
        if (number < 10) {
            offset = (number % 10) - 1;
            //number /= 10;
        } else if (number < 20) {
            offset = (number % 20) - 1;
            //number /= 100;
        }

        if (offset != NO_VALUE && offset < TOKENS.length) {
            buffer.append(TOKENS[offset]);
        }

        return buffer.toString();
    }

}
