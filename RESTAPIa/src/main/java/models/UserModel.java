package main.java.models;

import java.util.Objects;

public class UserModel {

		private Integer id;
		private String name;
		private String username;
		private String email;
		private Address address;
		private String phone;
		private String website;
		private Company company;
		
		public UserModel() {
		}
		/**
		*
		* @param website
		* @param address
		* @param phone
		* @param name
		* @param company
		* @param id
		* @param email
		* @param username
		*/
		public UserModel(Integer id, String name, String username, String email, Address address, String phone, String website, Company company) {
			super();
			this.id = id;
			this.name = name;
			this.username = username;
			this.email = email;
			this.address = address;
			this.phone = phone;
			this.website = website;
			this.company = company;
		}
		
		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public Address getAddress() {
			return address;
		}
		
		public void setAddress(Address address) {
			this.address = address;
		}
		
		public String getPhone() {
			return phone;
		}
		
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		public String getWebsite() {
			return website;
		}
		
		public void setWebsite(String website) {
			this.website = website;
		}
		
		public Company getCompany() {
			return company;
		}
		
		public void setCompany(Company company) {
			this.company = company;
		}
		@Override
		public boolean equals(Object obj) {
			
			 if (this == obj) {
		            return true;
		        }
			 if (obj == null || getClass() != obj.getClass()) {
		            return false;
		        }
			 UserModel userModel = (UserModel)obj;
			 
			 return this.id == userModel.id && this.name.equals(userModel.name) && this.username.equals(userModel.username) &&
					 this.email.equals(userModel.email)  && this.phone.equals(userModel.phone)
					 && this.website.equals(userModel.website) && this.company.equals(userModel.company)
					 && this.address.equals(userModel.address);
		}
		@Override
	    public int hashCode() {
	        return Objects.hash(id,name,username,email,phone,website,company);
	    }
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("id");
			sb.append('=');
			sb.append(((this.id == null)?"<null>":this.id));
			sb.append(',');
			sb.append("name");
			sb.append('=');
			sb.append(((this.name == null)?"<null>":this.name));
			sb.append(',');
			sb.append("username");
			sb.append('=');
			sb.append(((this.username == null)?"<null>":this.username));
			sb.append(',');
			sb.append("email");
			sb.append('=');
			sb.append(((this.email == null)?"<null>":this.email));
			sb.append(',');
			sb.append("address");
			sb.append('=');
			sb.append(((this.address == null)?"<null>":this.address));
			sb.append(',');
			sb.append("phone");
			sb.append('=');
			sb.append(((this.phone == null)?"<null>":this.phone));
			sb.append(',');
			sb.append("website");
			sb.append('=');
			sb.append(((this.website == null)?"<null>":this.website));
			sb.append(',');
			sb.append("company");
			sb.append('=');
			sb.append(((this.company == null)?"<null>":this.company));
			sb.append(',');
			if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
			} else {
			sb.append(']');
			}
			return sb.toString();
		}
}