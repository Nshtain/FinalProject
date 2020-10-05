package kolesnick.SummaryTask.db.entity;

import java.sql.Date;

public class Car extends Entity{

	private static final long serialVersionUID = 4851569582203129092L;
	
	private String brand;
	private String model;
	private String type;
	private String color;
	private Date earOfIssue;
	private String qualityClass;
	private double price;
	private boolean rentered;
	private int damageId;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getEarOfIssue() {
		return earOfIssue;
	}
	public void setEarOfIssue(Date earOfIssue) {
		this.earOfIssue = earOfIssue;
	}
	public String getQualityClass() {
		return qualityClass;
	}
	public void setQualityClass(String qualityClass) {
		this.qualityClass = qualityClass;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isRentered() {
		return rentered;
	}
	public void setRentered(boolean rentered) {
		this.rentered = rentered;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", type=" + type + ", color=" + color + ", earOfIssue="
				+ earOfIssue + ", qualityClass=" + qualityClass + ", price=" + price + ", rentered=" + rentered
				+ ", id=" + getId() + ", damageId=" + damageId + "]";
	}
	public int getDamageId() {
		return damageId;
	}
	public void setDamageId(int damageId) {
		this.damageId = damageId;
	}
	
	
}
