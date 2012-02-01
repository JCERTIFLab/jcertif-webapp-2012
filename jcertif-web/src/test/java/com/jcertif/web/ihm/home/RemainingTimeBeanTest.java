package com.jcertif.web.ihm.home;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for RemainingTimeBean.
 * 
 * @author rossi.oddet
 * 
 */
public class RemainingTimeBeanTest {

	/** Instance for test **/
	private RemainingTimeBean remainingTimeBean;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		remainingTimeBean = new RemainingTimeBean();
	}

	/**
	 * Test method for
	 * {@link com.jcertif.web.ihm.home.RemainingTimeBean#getRemainingTime(long)}
	 * .
	 */
	@Test
	public void testGetRemainingTimeZeroDay() {
		RemainingTime rtime = remainingTimeBean.getRemainingTime(1);
		assertEquals(Character.valueOf('0'), rtime.getHundred());
		assertEquals(Character.valueOf('0'), rtime.getDecade());
		assertEquals(Character.valueOf('0'), rtime.getDecade());
	}

	/**
	 * Test method for
	 * {@link com.jcertif.web.ihm.home.RemainingTimeBean#getRemainingTime(long)}
	 * .
	 */
	@Test
	public void testGetRemainingTimeOneDay() {
		RemainingTime rtime = remainingTimeBean.getRemainingTime(1000 * 60 * 60 * 25);
		assertEquals(Character.valueOf('0'), rtime.getHundred());
		assertEquals(Character.valueOf('0'), rtime.getDecade());
		assertEquals(Character.valueOf('1'), rtime.getUnit());
	}

	/**
	 * Test method for
	 * {@link com.jcertif.web.ihm.home.RemainingTimeBean#getRemainingTime(long)}
	 * .
	 */
	@Test
	public void testGetRemainingTimeElevenDay() {
		RemainingTime rtime = remainingTimeBean.getRemainingTime(1000 * 60 * 60 * 24 * 19);
		assertEquals(Character.valueOf('0'), rtime.getHundred());
		assertEquals(Character.valueOf('1'), rtime.getDecade());
		assertEquals(Character.valueOf('9'), rtime.getUnit());
	}

	/**
	 * Test method for
	 * {@link com.jcertif.web.ihm.home.RemainingTimeBean#getRemainingTime(long)}
	 * .
	 */
	@Test
	public void testGetRemainingTimeFiveHundredDay() {
		RemainingTime rtime = remainingTimeBean.getRemainingTime(Long.valueOf(1000 * 60 * 60 * 24
				* 550));
		assertEquals(Character.valueOf('5'), rtime.getHundred());
		assertEquals(Character.valueOf('5'), rtime.getDecade());
		assertEquals(Character.valueOf('0'), rtime.getUnit());
	}

}
