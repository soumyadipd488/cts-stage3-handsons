package com.soumyadip.DSadapter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.soumyadip.DSadapter.Movable;
import com.soumyadip.DSadapter.MovableAdapter;
import com.soumyadip.DSadapter.MovableAdapterImpl;
import com.soumyadip.DSadapter.BugattiVeyron;

public class SpeedTest {

	@Test 
	public void whenConvertingMPHToKMPH_thenSuccessfullyConverted() {
		Movable bugattiVeyron = new BugattiVeyron();
		MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron); 
		//System.out.println(bugattiVeyronAdapter.getSpeed());
		assertEquals(bugattiVeyronAdapter.getSpeed(), 431.30312, 0.00001); 
		}

}
