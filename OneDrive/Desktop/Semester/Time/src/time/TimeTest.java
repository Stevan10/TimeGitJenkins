/**
 * Taken from Wendi Jollymore :http://www-acad.sheridanc.on.ca/~jollymor/prog24178/oop2.html
 * @modfied by Stefan Mansoor
 * Used  as a base class
 * for the testing exercise with JUnit
 *  Winter 2023
 */
package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}

	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were  not calculated properly", seconds==18305);
	}
	
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,
				()-> {Time.getTotalSeconds("10:00");});
	}
	
	
	//Total seconds
	@ParameterizedTest
	@ValueSource(strings = { "00:00:30", "00:00:30",
	"00:00:30" })
	void testGetTotalSeconds(String s) {
	int seconds = Time.getTotalSeconds(s);
	assertTrue("The seconds were not calculated properly", seconds == 30);}

	//Seconds
	@ParameterizedTest
	@ValueSource(strings = { "00:00:40", "00:00:40",
	"00:00:40" })
	void testGetSeconds(String s) {
	int seconds = Time.getSeconds(s);
	assertTrue("The seconds were not calculated properly", seconds == 40);}
	
	//Total minutes
	@ParameterizedTest
	@ValueSource(strings = { "00:30:00", "00:30:00",
	"00:30:00" })
	void testGetTotalMinutes(String m) {
	int minutes = Time.getTotalMinutes(m);
	assertTrue("The seconds were not calculated properly", minutes == 30);}
	
	//Total hours
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15",
	"05:59:59" })
	void testGetTotalHours(String h) {
	int hours = Time.getTotalHours(h);
	assertTrue("The hours were not calculated properly", hours ==5);}
	
	
		@Test
		void testGetMillisecondsGood() {
			int mseconds = Time.getMilliseconds("12:05:05:005");
			assertTrue("The seconds were  not calculated properly", mseconds==5);
		}
		
		@Test
		void testGetTotalMillisecondsGood() {
			long mseconds = Time.getTotalMilliseconds("05:05:05:005");
			assertTrue("The seconds were  not calculated properly", mseconds==18035005);
		}
		
}
