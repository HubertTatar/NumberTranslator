package pl.huta.util.processor.polish;

import pl.huta.util.processor.AbstractProcessor;
import pl.huta.util.processor.ScaleUnit.Scale;
import pl.huta.util.processor.ScaleUnit.ScaleLang;

public class HundredProcessor extends AbstractProcessor {

    static private final String[] TOKENS = new String[] {
            "sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset", "siedemset", "osiemset", "dziewięćset"
    };
	
	private int EXPONENT = 2;
	private AbstractProcessor tensProcessor = null;
	private AbstractProcessor unitProcessor = null;

	public HundredProcessor(Scale scale, ScaleLang lang) {
		super(scale, lang);
		this.tensProcessor = new TensProcessor(scale, lang);
		this.unitProcessor = new UnitProcessor(scale, lang);
	}

	@Override
	public String getName(String value) {
        StringBuilder buffer = new StringBuilder();
		int number;
        if (value.isEmpty()) {
            number = 0;
        } else if (value.length() > 4) {
            number = Integer.valueOf(value.substring(value.length() - 4), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }

        number %= 1000;
        
        if (number >= 100) {
            buffer.append(TOKENS[(number / 100) - 1]);
        }

        String tensName = tensProcessor.getName(number % 100);

        if (!tensName.isEmpty() && (number >= 100)) {
            buffer.append(SEPARATOR);
        }
        buffer.append(tensName);

        return buffer.toString();
    }
}