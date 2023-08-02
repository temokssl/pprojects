package main.java.models;

import java.util.Objects;

public class Company {

		private String name;
		private String catchPhrase;
		private String bs;
		
		public Company() {
		}
		/**
		*
		* @param bs
		* @param catchPhrase
		* @param name
		*/
		public Company(String name, String catchPhrase, String bs) {
			super();
			this.name = name;
			this.catchPhrase = catchPhrase;
			this.bs = bs;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getCatchPhrase() {
			return catchPhrase;
		}
		
		public void setCatchPhrase(String catchPhrase) {
			this.catchPhrase = catchPhrase;
		}
		
		public String getBs() {
			return bs;
		}
		
		public void setBs(String bs) {
			this.bs = bs;
		}
		public boolean equals(Object obj) {
			
			 if (this == obj) {
		            return true;
		        }
			 if (obj == null || getClass() != obj.getClass()) {
		            return false;
		        }
			 
			 Company company = (Company)obj;
			 
			 return this.name.equals(company.name) && this.catchPhrase.equals(company.catchPhrase) &&
					 this.bs.equals(company.bs);
		}
		@Override
		public int hashCode() {
	       return Objects.hash(name,catchPhrase,bs);
	   }
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			//sb.append(Company.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
			sb.append("name");
			sb.append('=');
			sb.append(((this.name == null)?"<null>":this.name));
			sb.append(',');
			sb.append("catchPhrase");
			sb.append('=');
			sb.append(((this.catchPhrase == null)?"<null>":this.catchPhrase));
			sb.append(',');
			sb.append("bs");
			sb.append('=');
			sb.append(((this.bs == null)?"<null>":this.bs));
			sb.append(',');
			if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
			} else {
			sb.append(']');
			}
			return sb.toString();
		}
}