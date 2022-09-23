package com.fis.lip.beans;

public class TourPackage {
	private String packageId;
	private String source;
	private String dest;
	private double baseFare;

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public double getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("packageId=");
		builder.append(packageId);
		builder.append(", source=");
		builder.append(source);
		builder.append(", dest=");
		builder.append(dest);
		builder.append(", baseFare=");
		builder.append(baseFare);
		return builder.toString();
	}

}
