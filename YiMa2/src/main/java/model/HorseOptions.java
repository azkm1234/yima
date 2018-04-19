package model;

public class HorseOptions {
	
	private String sex;
	private String breed;
	private Integer age1;//年龄上下限
	private Integer age2;
	private Integer height1;
	private Integer height2;
	private String color;
	private String fromAddress;
	private String speciality;
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Integer getAge1() {
		return age1;
	}
	public void setAge1(Integer age1) {
		this.age1 = age1;
	}
	public Integer getAge2() {
		return age2;
	}
	public void setAge2(Integer age2) {
		this.age2 = age2;
	}
	public Integer getHeight1() {
		return height1;
	}
	public void setHeight1(Integer height1) {
		this.height1 = height1;
	}
	public Integer getHeight2() {
		return height2;
	}
	public void setHeight2(Integer height2) {
		this.height2 = height2;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
}
