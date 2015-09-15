package pl.huta.util.processor.polish;

import pl.huta.util.processor.ScaleUnit.Scale;
import pl.huta.util.processor.ScaleUnit.ScaleLang;

public class Processor {
	public static void main(String[] args) {
		CompositeBigProcessor c = new CompositeBigProcessor(Scale.LONG, ScaleLang.PL, 63);
		for (int i = 1; i < 10; i++) {
			System.out.println(i + ": " + c.getName(i * 111));
		}
	}
}
