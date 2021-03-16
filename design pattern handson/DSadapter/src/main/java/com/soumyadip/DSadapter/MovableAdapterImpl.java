package com.soumyadip.DSadapter;

public class MovableAdapterImpl implements MovableAdapter {
	private Movable luxuryCars;
	

	public MovableAdapterImpl(Movable luxuryCars) {
		super();
		this.luxuryCars = luxuryCars;
	}

	// standard constructors
	@Override
	public double getSpeed() {
		return convertMPHtoKMPH(luxuryCars.getSpeed());
	}
	
	@Override
	public double getPrice() {
		return convertUSDtoEuro(luxuryCars.getPrice());
	}
	private double convertUSDtoEuro(double price) {
		return price*0.84;
	}

	private double convertMPHtoKMPH(double mph) {
		return mph * 1.60934;
	}

	

}
