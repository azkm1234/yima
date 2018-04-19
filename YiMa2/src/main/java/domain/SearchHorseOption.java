package domain;

import java.util.List;

public class SearchHorseOption {
	private Integer pageSize;
	private Integer currentPage;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	private List<String> sex;
	private List<String> breed;
	private List<Integer> age1;
	private List<Integer> age2;
	private List<Integer> height1;
	private List<Integer> height2;
	private List<String> color;
	private List<String> fromAddress;
	private List<String> speciality;
	public List<String> getSex() {
		return sex;
	}
	public void setSex(List<String> sex) {
		this.sex = sex;
	}
	public List<String> getBreed() {
		return breed;
	}
	public void setBreed(List<String> breed) {
		this.breed = breed;
	}
	public List<Integer> getAge1() {
		return age1;
	}
	public void setAge1(List<Integer> age1) {
		this.age1 = age1;
	}
	public List<Integer> getAge2() {
		return age2;
	}
	public void setAge2(List<Integer> age2) {
		this.age2 = age2;
	}
	public List<Integer> getHeight1() {
		return height1;
	}
	public void setHeight1(List<Integer> height1) {
		this.height1 = height1;
	}
	public List<Integer> getHeight2() {
		return height2;
	}
	public void setHeight2(List<Integer> height2) {
		this.height2 = height2;
	}
	public List<String> getColor() {
		return color;
	}
	public void setColor(List<String> color) {
		this.color = color;
	}
	public List<String> getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(List<String> fromAddress) {
		this.fromAddress = fromAddress;
	}
	public List<String> getSpeciality() {
		return speciality;
	}
	public void setSpeciality(List<String> speciality) {
		this.speciality = speciality;
	}
	
}
