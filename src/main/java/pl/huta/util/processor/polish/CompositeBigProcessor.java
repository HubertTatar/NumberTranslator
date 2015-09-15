package pl.huta.util.processor.polish;

import pl.huta.util.processor.AbstractProcessor;
import pl.huta.util.processor.ScaleUnit.Scale;
import pl.huta.util.processor.ScaleUnit.ScaleLang;

public class CompositeBigProcessor extends AbstractProcessor {
	private AbstractProcessor hundredProcessor = null;
	private AbstractProcessor lowProcessor;

	private int exponent;

	public CompositeBigProcessor(Scale scale, ScaleLang lang, int exponent) {
		super(scale, lang);
		this.scale = scale;
		this.lang = lang;
		this.exponent = exponent;

		hundredProcessor = new HundredProcessor(scale, lang);

		if (exponent < 3) {
			this.lowProcessor = hundredProcessor;
		} else {
			this.lowProcessor = new CompositeBigProcessor(scale, lang, exponent - 3);
		}
	}

	@Override
	public String getName(String value) {
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
