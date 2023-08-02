package main.java.models;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")

public class TestDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String testName;
	@Column(name = "status_id")
	private Integer testStatus;
	@Column(name = "method_name")
	private String testMethodName;
	@Column(name = "project_id")
	private Integer projectId;
	@Column(name = "session_id")
	private Integer sessionId;
	@Column(name = "start_time")
	private String startTime;
	@Column(name = "end_time")
	private String endTime;
	@Column(name = "env")
	private String env;
	@Column(name = "browser")
	private String browser;
	@Column(name = "author_id", nullable = true)
	private String authorId;


	public TestDTO() {
	}

	public TestDTO(Integer id, String testName, Integer testStatus, String testMethodName,Integer projectId,Integer sessionId,String startTime,String endTime,
			String env,String browser,String authorId) {
		super();
		this.id = id;
		this.testName = testName;
		this.testStatus = testStatus;  
		this.testMethodName = testMethodName;
		this.projectId = projectId;
		this.sessionId = sessionId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.env = env;
		this.browser = browser;
		this.authorId = authorId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	public Integer getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(Integer testStatus) {
		this.testStatus = testStatus;
	}
	
	public String getTestMethodName() {
		return testMethodName;
	}

	public void setTestMethodName(String testMethodName) {
		this.testMethodName = testMethodName;
	}
	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
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
	
	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}
	
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	
	@Override
	public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(TestDTO.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
	sb.append("id");
	sb.append('=');
	sb.append(((this.id == null)?"<null>":this.id));
	sb.append(',');
	sb.append("testName");
	sb.append('=');
	sb.append(((this.testName == null)?"<null>":this.testName));
	sb.append(',');
	sb.append("testStatus");
	sb.append('=');
	sb.append(((this.testStatus == null)?"<null>":this.testStatus));
	sb.append(',');
	sb.append("testMethodName");
	sb.append('=');
	sb.append(((this.testMethodName == null)?"<null>":this.testMethodName));
	sb.append(',');
	sb.append("projectId");
	sb.append('=');
	sb.append(((this.projectId == null)?"<null>":this.projectId));
	sb.append(',');
	sb.append("sessionId");
	sb.append('=');
	sb.append(((this.sessionId == null)?"<null>":this.sessionId));
	sb.append(',');
	sb.append("startTime");
	sb.append('=');
	sb.append(((this.startTime == null)?"<null>":this.startTime));
	sb.append(',');
	sb.append("endTime");
	sb.append('=');
	sb.append(((this.endTime == null)?"<null>":this.endTime));
	sb.append(',');
	sb.append("env");
	sb.append('=');
	sb.append(((this.env == null)?"<null>":this.env));
	sb.append(',');
	sb.append("browser");
	sb.append('=');
	sb.append(((this.browser == null)?"<null>":this.browser));
	sb.append(',');
	sb.append("authorId");
	sb.append('=');
	sb.append(((this.authorId == null)?"<null>":this.authorId));
	sb.append(',');
	if (sb.charAt((sb.length()- 1)) == ',') {
	sb.setCharAt((sb.length()- 1), ']');
	} else {
	sb.append(']');
	}
	return sb.toString();
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

		 return this.testName.equals(dto.testName) && this.testStatus==dto.testStatus &&
				 this.testMethodName.equals(dto.testMethodName)  && this.projectId==dto.projectId
				 && this.sessionId==dto.sessionId && this.startTime.equals(dto.startTime)
				 && this.endTime.equals(dto.endTime) && this.env.equals(dto.env) &&
				 this.browser.equals(dto.browser) && this.authorId.equals(dto.authorId);
	}
	@Override
    public int hashCode() {
        return Objects.hash(id,testName,testStatus,testMethodName,projectId,sessionId,startTime,endTime,env
        		,browser,authorId);
    }
}