package com.soumyadip.DSadapter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.soumyadip.DSadapter.Movable;
import com.soumyadip.DSadapter.MovableAdapter;
import com.soumyadip.DSadapter.MovableAdapterImpl;
import com.soumyadip.DSadapter.BugattiVeyron;

public class CurrencyTest {
	
	@Test 
	public void whenConvertingUSDtoEuro_thenSuccessfullyConverted() {
		Movable bugattiVeyron = new BugattiVeyron();
		MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron); 
		//System.out.println(bugattiVeyronAdapter.getPrice());
		assertEquals(bugattiVeyronAdapter.getPrice(), 1260.0, 0.001); 
		}

}
