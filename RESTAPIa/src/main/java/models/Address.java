package main.java.models;

import java.util.Objects;

public class Address {
	
		private String street;
		private String suite;
		private String city;
		private String zipcode;
		private Geo geo;
		
		public Address() {
		}
		/**
		*
		* @param zipcode
		* @param geo
		* @param suite
		* @param city
		* @param street
		*/
		public Address(String street, String suite, String city, String zipcode, Geo geo) {
			super();
			this.street = street;
			this.suite = suite;
			this.city = city;
			this.zipcode = zipcode;
			this.geo = geo;
		}
		
		public String getStreet() {
			return street;
		}
		
		public void setStreet(String street) {
			this.street = street;
		}
		
		public String getSuite() {
			return suite;
		}
		
		public void setSuite(String suite) {
			this.suite = suite;
		}
		
		public String getCity() {
			return city;
		}
		
		public void setCity(String city) {
			this.city = city;
		}
		
		public String getZipcode() {
			return zipcode;
		}
		
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
		
		public Geo getGeo() {
			return geo;
		}
		
		public void setGeo(Geo geo) {
			this.geo = geo;
		}
		@Override
		public boolean equals(Object obj) {
			
			 if (this == obj) {
		            return true;
		        }
			 if (obj == null || getClass() != obj.getClass()) {
		            return false;
		        }
			 
			 Address address = (Address)obj;
			 
			 return this.street.equals(address.street) && this.suite.equals(address.suite) &&
					 this.city.equals(address.city) && this.zipcode.equals(address.zipcode)
					 && this.geo.equals(address.geo);
		}
		@Override
	    public int hashCode() {
	        return Objects.hash(street,suite,city,zipcode,geo);
	    }
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			//sb.append(Address.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
			sb.append("street");
			sb.append('=');
			sb.append(((this.street == null)?"<null>":this.street));
			sb.append(',');
			sb.append("suite");
			sb.append('=');
			sb.append(((this.suite == null)?"<null>":this.suite));
			sb.append(',');
			sb.append("city");
			sb.append('=');
			sb.append(((this.city == null)?"<null>":this.city));
			sb.append(',');
			sb.append("zipcode");
			sb.append('=');
			sb.append(((this.zipcode == null)?"<null>":this.zipcode));
			sb.append(',');
			sb.append("geo");
			sb.append('=');
			sb.append(((this.geo == null)?"<null>":this.geo));
			sb.append(',');
			if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
			} else {
			sb.append(']');
			}
			return sb.toString();
		}
}