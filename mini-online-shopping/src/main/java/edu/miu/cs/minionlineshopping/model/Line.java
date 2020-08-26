package edu.miu.cs.minionlineshopping.model;

public class Line {

	private double quantity;
	private double unitPrie;
	private double totalPrice;

	public Line() {

	}

	public Line(double quantity, double unitPrie) {
		this.quantity = quantity;
		this.unitPrie = unitPrie;
		this.totalPrice = quantity * unitPrie;
	}

	public Line getLine() {
		return this;
	}
}
