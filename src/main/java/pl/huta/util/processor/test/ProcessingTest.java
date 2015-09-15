package pl.huta.util.processor.test;

import java.util.Date;

import pl.huta.util.processor.Processor;
import pl.huta.util.processor.ProcessorFactory;
import pl.huta.util.processor.ProcessorFactory.ProcessorEnum;

public class ProcessingTest {
	private static Processor processor;

	public static void main(String[] args) {
		//testEngShrt();	
		//testEngLng();
		//testPLShrt();
		//System.out.println(new Date().getTime());
		//System.out.println(Long.MAX_VALUE);
		test();
	}
	
	private static void test() {
		initProcessor(ProcessorEnum.BRITISH_LONG);
		System.out.println(processor.getName(100));
	}
	
	private static void testEngLng() {
        
		initProcessor(ProcessorEnum.BRITISH_LONG);
		
        for (long val : getLongVals()) {
            System.out.println(val + " = " + processor.getName(val) );
        }

        for (String strVal : getStringVals()) {
            System.out.println(strVal + " = " + processor.getName(strVal) );
        }

        System.out.println(getVeryBigNum().toString() + " = " + processor.getName(getVeryBigNum().toString()));
	}

	private static void initProcessor(ProcessorEnum option) {
		ProcessorFactory factory = new ProcessorFactory();
		processor = factory.createProcessor(option);
	}
	
	private static void testPLShrt() {
		
		initProcessor(ProcessorEnum.POLISH_SHORT);
		
		for (long val : getLongVals()) {
			System.out.println(val + " = " + processor.getName(val) );
		}
		
		for (String strVal : getStringVals()) {
			System.out.println(strVal + " = " + processor.getName(strVal) );
		}
		
		System.out.println(getVeryBigNum().toString() + " = " + processor.getName(getVeryBigNum().toString()));
	}

	private static void testEngShrt() {
		
		initProcessor(ProcessorEnum.BRITISH_SHORT);
		
		for (long val : getLongVals()) {
			System.out.println(val + " = " + processor.getName(val) );
		}
		
		for (String strVal : getStringVals()) {
			System.out.println(strVal + " = " + processor.getName(strVal) );
		}
		
		System.out.println(getVeryBigNum().toString() + " = " + processor.getName(getVeryBigNum().toString()));
	}
	
	private static String getVeryBigNum() {
		StringBuilder bigNumber = new StringBuilder();
        for (int d=0; d<66; d++) {
            bigNumber.append( (char) ((Math.random() * 10) + '0'));
        }
        bigNumber.append(".");
        for (int d=0; d<26; d++) {
            bigNumber.append( (char) ((Math.random() * 10) + '0'));
        }
        return bigNumber.toString();
	}
	
	private static String[] getStringVals() {
		return new String[] {
                "0001.2",
                "3.141592"
        };
	}
	
	private static long[] getLongVals() {
		return new long[] {
                0,
                4,
                10,
                12,
                100,
                108,
                299,
                1000,
                1003,
                2040,
                45213,
                100000,
                100005,
                100010,
                202020,
                202022,
                999999,
                1000000,
                1000001,
                10000000,
                10000007,
                99999999,
                Long.MAX_VALUE,
                Long.MIN_VALUE
        };
	}
}
