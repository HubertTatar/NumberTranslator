package pl.huta.util.processor.polish;

import pl.huta.util.processor.AbstractProcessor;
import pl.huta.util.processor.ScaleUnit.Scale;
import pl.huta.util.processor.ScaleUnit.ScaleLang;
import pl.huta.util.processor.polish.UnitProcessor;

public class TensProcessor extends AbstractProcessor {

    static private final String[] TOKENS = new String[] {
            "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"
    };
	
    static private final String UNION_SEPARATOR = " ";

    private UnitProcessor unitProcessor = new UnitProcessor(scale, lang);

    
	public TensProcessor(Scale scale, ScaleLang lang) {
		super(scale, lang);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName(String value) {
        StringBuilder buffer = new StringBuilder();
        boolean tensFound = false;

        int number;
        if (value.length() > 3) {
            number = Integer.valueOf(value.substring(value.length() - 3), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }
        number %= 100;   // keep only two digits
        if (number >= 20) {
            buffer.append(TOKENS[(number / 10) - 2]);
            number %= 10;
            tensFound = true;
        } else {
            number %= 20;
        }

        if (number != 0) {
            if (tensFound) {
                buffer.append(UNION_SEPARATOR);
            }
            buffer.append(unitProcessor.getName(number));
        }

        return buffer.toString();
	}

}
