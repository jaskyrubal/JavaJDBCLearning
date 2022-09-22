package com.fis.lip.beans;

public class TourCost {
	private int days;
	private double baseFare;
	private double totalBaseCost;
	private double discountRate;
	private double discount;
	private double discountedCost;
	private double gst;
	private double totalCost;
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public double getBaseFare() {
		return baseFare;
	}
	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}
	public double getTotalBaseCost() {
		return totalBaseCost;
	}
	public void setTotalBaseCost(double totalBaseCost) {
		this.totalBaseCost = totalBaseCost;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getDiscountedCost() {
		return discountedCost;
	}
	public void setDiscountedCost(double discountedCost) {
		this.discountedCost = discountedCost;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		StringBuilder builder  =  new StringBuilder();
		builder.append("\nNumber of days = ");
		builder.append(days);
		builder.append("\nBase Fare = ");
		builder.append(baseFare);
		builder.append("\nTotal Base Cost = ");
		builder.append(totalBaseCost);
		builder.append("\nDiscount Rate = ");
		builder.append(discountRate);
		builder.append("\nDiscount = ");
		builder.append(discount);
		builder.append("\nDiscounted Cost = ");
		builder.append(discountedCost);
		builder.append("\nGST = ");
		builder.append(gst);
		builder.append("\nTotal Cost = ");
		builder.append(totalCost);
		return builder.toString();
	}
	
	

}
