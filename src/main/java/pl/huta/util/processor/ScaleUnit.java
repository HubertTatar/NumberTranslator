package pl.huta.util.processor;

import java.util.HashMap;
import java.util.Map;

/**
 *	Defines names for powers
 */
public class ScaleUnit {
    private int exponent;
    private String[] names;
    
    private ScaleUnit(int exponent, String...names) {
        this.exponent = exponent;
        this.names = names;
    }
    public int getExponent() {
        return exponent;
    }
    public String getName(int index) {
        return names[index];
    }

	static private ScaleUnit[] SCALE_UNITS_PL = new ScaleUnit[] {
			new ScaleUnit(63, "wigintylion", "decyliard"),
			new ScaleUnit(60, "nowemdecylion", "decylion"),
			new ScaleUnit(57, "octodecylion", "nonyliard"),
			new ScaleUnit(54, "septendecylion", "nonylion"),
			new ScaleUnit(51, "seksdecylion", "oktyliard"),
			new ScaleUnit(48, "kwindecylion", "oktylion"),
			new ScaleUnit(45, "kwatuordecylion", "septyliard"),
			new ScaleUnit(42, "tredecylion", "septylion"),
			new ScaleUnit(39, "duodecylion", "sekstyliard"),
			new ScaleUnit(36, "undecylion", "sekstylion"),
			new ScaleUnit(33, "decylion", "kwintyliard"),
			new ScaleUnit(30, "nowentylion", "kwintylion"),
			new ScaleUnit(27, "oktylion", "kwadryliard"),
			new ScaleUnit(24, "septylion", "kwadrylion"),
			new ScaleUnit(21, "sekstylion", "tryliard"),
			new ScaleUnit(18, "kwintylion", "trylion"),
			new ScaleUnit(15, "kwadrylion", "biliard"),
			new ScaleUnit(12, "trylion", "bilion"),
			new ScaleUnit(9, "bilion", "miliard"),
			new ScaleUnit(6, "milion", "milion"),
			new ScaleUnit(3, "tysiąc", "tysiąc"),
			new ScaleUnit(2, "sto", "sto"),
			new ScaleUnit(-1, "dziesiąta", "dziesiąta"),
			new ScaleUnit(-2, "setna", "setna"),
			new ScaleUnit(-3, "tysięczna", "tysięczna"),
			new ScaleUnit(-4, "", "dziesięcio-tysięczna"),
			new ScaleUnit(-5, "", "stu-tysięczna"),
			new ScaleUnit(-6, "", "milionowa"),
			new ScaleUnit(-7, "", "dziesięcio-milionowa"),
			new ScaleUnit(-8, "", "stu-milionowa"),
			new ScaleUnit(-9, "bilionowa", "miliardowa"),
			new ScaleUnit(-10, "", "dziesięcio-miliardowa"),
			new ScaleUnit(-11, "", "stu-miliardowa"),
			new ScaleUnit(-12, "trylionowa", "bilionowa"),
			new ScaleUnit(-13, "", "dziesięcio-bilionowa"),
			new ScaleUnit(-14, "", "stu-bilionowa"),
			new ScaleUnit(-15, "kwadrylionowa", "biliardowa"),
			new ScaleUnit(-16, "", "dziesięcio-biliardowa"),
			new ScaleUnit(-17, "", "stu-biliardowa"),
			new ScaleUnit(-18, "kwintylionowa", "trylionowa"),
			new ScaleUnit(-19, "", "dziesięcio-trylionowa"),
			new ScaleUnit(-20, "", "stu-trylionowa"),
			new ScaleUnit(-21, "sekstylionowa", "tryliardowa"),
			new ScaleUnit(-22, "", "dziesięcio-tryliardowa"),
			new ScaleUnit(-23, "", "stu-tryliardowa"),
			new ScaleUnit(-24, "septylionowa", "kwadrylionowa"),
			new ScaleUnit(-25, "", "dziesięcio-kwadrylionowa"),
			new ScaleUnit(-26, "", "stu-kwadrylionowa"),
	};
	
	   static private ScaleUnit[] SCALE_UNITS_ENG = new ScaleUnit[] {
	            new ScaleUnit(63, "vigintillion", "decilliard"),
	            new ScaleUnit(60, "novemdecillion", "decillion"),
	            new ScaleUnit(57, "octodecillion", "nonilliard"),
	            new ScaleUnit(54, "septendecillion", "nonillion"),
	            new ScaleUnit(51, "sexdecillion", "octilliard"),
	            new ScaleUnit(48, "quindecillion", "octillion"),
	            new ScaleUnit(45, "quattuordecillion", "septilliard"),
	            new ScaleUnit(42, "tredecillion", "septillion"),
	            new ScaleUnit(39, "duodecillion", "sextilliard"),
	            new ScaleUnit(36, "undecillion", "sextillion"),
	            new ScaleUnit(33, "decillion", "quintilliard"),
	            new ScaleUnit(30, "nonillion", "quintillion"),
	            new ScaleUnit(27, "octillion", "quadrilliard"),
	            new ScaleUnit(24, "septillion", "quadrillion"),
	            new ScaleUnit(21, "sextillion", "trilliard"),
	            new ScaleUnit(18, "quintillion", "trillion"),
	            new ScaleUnit(15, "quadrillion", "billiard"),
	            new ScaleUnit(12, "trillion", "billion"),
	            new ScaleUnit(9, "billion", "milliard"),
	            new ScaleUnit(6, "million", "million"),
	            new ScaleUnit(3, "thousand", "thousand"),
	            new ScaleUnit(2, "hundred", "hundred"),
	            //new ScaleUnit(1, "ten", "ten"),
	            //new ScaleUnit(0, "one", "one"),
	            new ScaleUnit(-1, "tenth", "tenth"),
	            new ScaleUnit(-2, "hundredth", "hundredth"),
	            new ScaleUnit(-3, "thousandth", "thousandth"),
	            new ScaleUnit(-4, "ten-thousandth", "ten-thousandth"),
	            new ScaleUnit(-5, "hundred-thousandth", "hundred-thousandth"),
	            new ScaleUnit(-6, "millionth", "millionth"),
	            new ScaleUnit(-7, "ten-millionth", "ten-millionth"),
	            new ScaleUnit(-8, "hundred-millionth", "hundred-millionth"),
	            new ScaleUnit(-9, "billionth", "milliardth"),
	            new ScaleUnit(-10, "ten-billionth", "ten-milliardth"),
	            new ScaleUnit(-11, "hundred-billionth", "hundred-milliardth"),
	            new ScaleUnit(-12, "trillionth", "billionth"),
	            new ScaleUnit(-13, "ten-trillionth", "ten-billionth"),
	            new ScaleUnit(-14, "hundred-trillionth", "hundred-billionth"),
	            new ScaleUnit(-15, "quadrillionth", "billiardth"),
	            new ScaleUnit(-16, "ten-quadrillionth", "ten-billiardth"),
	            new ScaleUnit(-17, "hundred-quadrillionth", "hundred-billiardth"),
	            new ScaleUnit(-18, "quintillionth", "trillionth"),
	            new ScaleUnit(-19, "ten-quintillionth", "ten-trillionth"),
	            new ScaleUnit(-20, "hundred-quintillionth", "hundred-trillionth"),
	            new ScaleUnit(-21, "sextillionth", "trilliardth"),
	            new ScaleUnit(-22, "ten-sextillionth", "ten-trilliardth"),
	            new ScaleUnit(-23, "hundred-sextillionth", "hundred-trilliardth"),
	            new ScaleUnit(-24, "septillionth","quadrillionth"),
	            new ScaleUnit(-25, "ten-septillionth","ten-quadrillionth"),
	            new ScaleUnit(-26, "hundred-septillionth","hundred-quadrillionth"),
	    };

	static Map<ScaleLang, ScaleUnit[]> unitsMap = new HashMap<ScaleLang, ScaleUnit[]>() {
		private static final long serialVersionUID = -4876618659905924216L;

	{
		put(ScaleLang.PL, SCALE_UNITS_PL);
		put(ScaleLang.ENG, SCALE_UNITS_ENG);
	}};
	   
	/**
	 * Defines available languages of scales
	 */
	public enum ScaleLang {
		PL, ENG
	}
    /**
     * Defines which name from ScaleUnit will be choosen
     */
    public enum Scale {
        SHORT,
        LONG;

        public String getName(int exponent, ScaleLang lang) {
            for (ScaleUnit unit : unitsMap.get(lang)) {
                if (unit.getExponent() == exponent) {
                    return unit.getName(this.ordinal());
                }
            }
            return "";
        }
    }
}
