package com.ui.pojo;

public class AddressPojo {
 
	private String company;
	private String address1;
	private String address2;
	private String city;
	private String zipcode;
	private String home_phone;
	private String mobile_phone;
	private String additional_info;
	private String address_title;
	private String state;
	public AddressPojo(String company, String address1, String address2, String city, String zipcode, String home_phone,
			String mobile_phone, String additional_info, String address_title, String state) {
		super();
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.zipcode = zipcode;
		this.home_phone = home_phone;
		this.mobile_phone = mobile_phone;
		this.additional_info = additional_info;
		this.address_title = address_title;
		this.state = state;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @return the home_phone
	 */
	public String getHome_phone() {
		return home_phone;
	}
	/**
	 * @return the mobile_phone
	 */
	public String getMobile_phone() {
		return mobile_phone;
	}
	/**
	 * @return the additional_info
	 */
	public String getAdditional_info() {
		return additional_info;
	}
	/**
	 * @return the address_title
	 */
	public String getAddress_title() {
		return address_title;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	@Override
	public String toString() {
		return "AddressPojo [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", zipcode=" + zipcode + ", home_phone=" + home_phone + ", mobile_phone=" + mobile_phone
				+ ", additional_info=" + additional_info + ", address_title=" + address_title + ", state=" + state
				+ "]";
	}
	
}
