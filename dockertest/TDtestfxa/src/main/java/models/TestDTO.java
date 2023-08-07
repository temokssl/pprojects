package main.java.models;

public class TestDTO {

	private String duration;
	private String method;
	private String name;
	private String startTime;
	private String endTime;
	private String status;
	
	public TestDTO() {
	}
	
	public TestDTO(String duration, String method, String name, String startTime, String endTime, String status) {
		super();
		this.duration = duration;
		this.method = method;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public boolean equals(Object obj) {

		 if (this == obj) {
	            return true;
	        }
		 if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
		 TestDTO dto = (TestDTO)obj;

		 return this.name.equals(dto.name) && this.startTime.equals(dto.startTime);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(TestDTO.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("duration");
		sb.append('=');
		sb.append(((this.duration == null)?"<null>":this.duration));
		sb.append(',');
		sb.append("method");
		sb.append('=');
		sb.append(((this.method == null)?"<null>":this.method));
		sb.append(',');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null)?"<null>":this.name));
		sb.append(',');
		sb.append("startTime");
		sb.append('=');
		sb.append(((this.startTime == null)?"<null>":this.startTime));
		sb.append(',');
		sb.append("endTime");
		sb.append('=');
		sb.append(((this.endTime == null)?"<null>":this.endTime));
		sb.append(',');
		sb.append("status");
		sb.append('=');
		sb.append(((this.status == null)?"<null>":this.status));
		sb.append(',');
		if (sb.charAt((sb.length()- 1)) == ',') {
		sb.setCharAt((sb.length()- 1), ']');
		} else {
		sb.append(']');
		}
		return sb.toString();
	}
	
}