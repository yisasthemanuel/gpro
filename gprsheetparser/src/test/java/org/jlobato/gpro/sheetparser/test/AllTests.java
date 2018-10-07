package org.jlobato.gpro.sheetparser.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	BrandsHatchS49XLSXTest.class,
	BrandsHatchS49XLSTest.class,
	AustinS49XLSXTest.class,
	AhvenistoS49XLSXTest.class,
	IrungattukottaiS49XLSXTest.class,
	NoWetRisksTest.class,
	WrongSheetFormatTest.class,
	NoStopsTest.class
})
public class AllTests {

}
