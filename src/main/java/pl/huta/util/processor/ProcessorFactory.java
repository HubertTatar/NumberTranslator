package pl.huta.util.processor;

import pl.huta.util.processor.english.DefaultProcessor;
import pl.huta.util.processor.ScaleUnit.Scale;
import pl.huta.util.processor.ScaleUnit.ScaleLang;

public class ProcessorFactory {

    public Processor createProcessor(ProcessorEnum processorEnum) {
    	Processor processor = null;
    	switch (processorEnum.number) {
            case 1:
            	processor = new DefaultProcessor(Scale.SHORT, ScaleLang.ENG);
                break;
            case 2:
            	processor = new DefaultProcessor(Scale.LONG, ScaleLang.ENG);
                break;
            case 3:
            	processor = new DefaultProcessor(Scale.SHORT, ScaleLang.PL);
                break;
            case 4:    
            	processor = new DefaultProcessor(Scale.LONG, ScaleLang.PL);
                break;
            default:
                throw new IllegalArgumentException(String.format("Processor of type %s is not implemented", processorEnum.name()));
        }
        return processor;
    }

    public enum ProcessorEnum {
    	BRITISH_SHORT(1), BRITISH_LONG(2), POLISH_SHORT(3), POLISH_LONG(4) ;

        private int number;

        private ProcessorEnum(int number) {
            this.number = number;
        }

    }

}
