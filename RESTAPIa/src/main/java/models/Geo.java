package main.java.models;

import java.util.Objects;

public class Geo {

		private String lat;
		private String lng;
		
		public Geo() {
		}
		
		/**
		*
		* @param lng
		* @param lat
		*/
		public Geo(String lat, String lng) {
			super();
			this.lat = lat;
			this.lng = lng;
		}
		
		public String getLat() {
			return lat;
		}
		
		public void setLat(String lat) {
			this.lat = lat;
		}
		
		public String getLng() {
			return lng;
		}
		
		public void setLng(String lng) {
			this.lng = lng;
		}
		@Override
		public boolean equals(Object obj) {
			
			 if (this == obj) {
		            return true;
		        }
			 if (obj == null || getClass() != obj.getClass()) {
		            return false;
		        }
			 
			 Geo geo = (Geo)obj;
			 
			 return this.lat.equals(geo.lat) && this.lng.equals(geo.lng); 
		}
		@Override
	    public int hashCode() {
	        return Objects.hash(lat,lng);
	    }
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			//sb.append(Geo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
			sb.append("lat");
			sb.append('=');
			sb.append(((this.lat == null)?"<null>":this.lat));
			sb.append(',');
			sb.append("lng");
			sb.append('=');
			sb.append(((this.lng == null)?"<null>":this.lng));
			sb.append(',');
			if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
			} else {
			sb.append(']');
			}
			return sb.toString();
		}
}