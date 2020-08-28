package edu.miu.cs.minionlineshopping.model;

public enum Tax {
	LOW(5), MEDIUM(10), HIGH(15);

	private final double value;

	Tax(final double newValue) {
		value = newValue;
	}

	public double getValue() {
		return value;
	}
}
