package com.javaexpert.fundtransfer.model;
public class CrossRate {
	private String fromCcy;
	private String toCcy;
	private double crossRate;
	public String getFromCcy() {
		return fromCcy;
	}
	public void setFromCcy(String fromCcy) {
		this.fromCcy = fromCcy;
	}
	public String getToCcy() {
		return toCcy;
	}
	public void setToCcy(String toCcy) {
		this.toCcy = toCcy;
	}
	public double getCrossRate() {
		return crossRate;
	}
	public void setCrossRate(double crossRate) {
		this.crossRate = crossRate;
	}
	public CrossRate(String fromCcy, String toCcy, double crossRate) {
		super();
		this.fromCcy = fromCcy;
		this.toCcy = toCcy;
		this.crossRate = crossRate;
	}
	
	
}
