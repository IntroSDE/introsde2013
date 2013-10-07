package service.health.pojos;

public class HealthProfile {
	private double weight; // in kg
	private double height; // in m

	public HealthProfile(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}

	public HealthProfile() {
		this.weight = 85.5;
		this.height = 1.72;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Calculate the BMI (weight/(Math.pow(height,2)) of the this profile based
	 * on the current weight and height
	 * 
	 * @return the BMI
	 */
	public double getBMI() {
		return weight / (Math.pow(height, 2));
	}
	
	public String toString() {
		return "Height="+height+", Weight="+weight;
	}

}
