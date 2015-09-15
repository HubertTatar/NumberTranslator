package pl.huta.util.processor.english;

import pl.huta.util.processor.AbstractProcessor;
import pl.huta.util.processor.ScaleUnit.Scale;
import pl.huta.util.processor.ScaleUnit.ScaleLang;

/**
 * Created by huta on 31.08.15.
 */
public class CompositeBigProcessor extends AbstractProcessor {
	private AbstractProcessor hundredProcessor = null;
	private AbstractProcessor lowProcessor;
	private int exponent;

	public CompositeBigProcessor(int exponent, Scale scale, ScaleLang lang) {
		super(scale, lang);

		System.out.println(">>CompositeBigProcessor<<");
		hundredProcessor = new HundredProcessor(scale, lang);
		this.exponent = exponent;

		if (exponent <= 3) {
			lowProcessor = hundredProcessor;
		} else {
			System.out.println(scale.getName(exponent, lang));
			lowProcessor = new CompositeBigProcessor(exponent - 3, scale, lang);
		}
	}

	@Override
	public String getName(String value) {
		System.out.println(String.format("Wywołuje composite: %s ", value));
		StringBuilder buffer = new StringBuilder();

		String high, low;
		if (value.length() < getPartDivider()) {
			high = "";
			low = value;
		} else {
			int index = value.length() - getPartDivider();
			high = value.substring(0, index);
			low = value.substring(index);
		}

		String highName = getHighProcessor().getName(high);
		String lowName = getLowProcessor().getName(low);

		if (!highName.isEmpty()) {
			buffer.append(highName);
			buffer.append(SEPARATOR);
			buffer.append(getToken());

			if (!lowName.isEmpty()) {
				buffer.append(SEPARATOR);
			}
		}

		if (!lowName.isEmpty()) {
			buffer.append(lowName);
		}

		return buffer.toString();
	}

	public String getToken() {
		return scale.getName(getPartDivider(), lang);
	}

	protected AbstractProcessor getHighProcessor() {
		return hundredProcessor;
	}

	protected AbstractProcessor getLowProcessor() {
		return lowProcessor;
	}

	public int getPartDivider() {
		return exponent;
	}
}
