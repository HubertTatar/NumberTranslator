package pl.huta.util.processor.english;

import pl.huta.util.processor.AbstractProcessor;
import pl.huta.util.processor.ScaleUnit.Scale;
import pl.huta.util.processor.ScaleUnit.ScaleLang;

/**
 * Created by huta on 31.08.15.
 */
public class HundredProcessor extends AbstractProcessor {

    private int EXPONENT = 2;

    private UnitProcessor unitProcessor = null;
    private TensProcessor tensProcessor = null;

    public HundredProcessor(Scale scale, ScaleLang lang) {
		super(scale, lang);
		System.out.println(">>HundredProcessor<<");
		unitProcessor = new UnitProcessor(scale, lang);
		tensProcessor =  new TensProcessor(scale, lang);
	}

	@Override
    public String getName(String value) {
		System.out.println(String.format("Wywołuje hundred: %s ", value));
        StringBuilder buffer = new StringBuilder();

        int number;
        if (value.isEmpty()) {
            number = 0;
        } else if (value.length() > 4) {
            number = Integer.valueOf(value.substring(value.length() - 4), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }
        number %= 1000;  // keep at least three digits

        if (number >= 100) {
            buffer.append(unitProcessor.getName(number / 100));
            buffer.append(SEPARATOR);
            buffer.append(scale.getName(EXPONENT, lang));
        }

        String tensName = tensProcessor.getName(number % 100);

        if (!tensName.isEmpty() && (number >= 100)) {
            buffer.append(SEPARATOR);
        }
        buffer.append(tensName);

        return buffer.toString();
    }
}
