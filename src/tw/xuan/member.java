package tw.xuan;

import java.io.Serializable;

public class member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int years;
	private String typs;
	private String companys;
	private String products;

	public member() {
	}

	public member(int id, int years, String typs, String companys, String products) {

		this.id = id;
		this.years = years;
		this.typs = typs;
		this.companys = companys;
		this.products = products;
	}

	public member(int years, String typs, String companys, String products) {

		this.years = years;
		this.typs = typs;
		this.companys = companys;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public String getTyps() {
		return typs;
	}

	public void setTyps(String typs) {
		this.typs = typs;
	}

	public String getCompanys() {
		return companys;
	}

	public void setCompanys(String companys) {
		this.companys = companys;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
