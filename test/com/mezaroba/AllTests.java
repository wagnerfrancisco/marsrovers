package com.mezaroba;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ InputProcessorTest.class, LocationTest.class,
		OrientationTest.class, PlateauTest.class, RoverControllerTest.class,
		RoverTest.class })
public class AllTests {

}
