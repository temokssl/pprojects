package main.java.models;

public class PostModel {
	
		private Integer userId;
		private Integer id;
		private String title;
		private String body;
		
		
		public PostModel() {
		}
		
		/**
		*
		* @param id
		* @param title
		* @param body
		* @param userId
		*/
		public PostModel(Integer userId, Integer id, String title, String body) {
			super();
			this.userId = userId;
			this.id = id;
			this.title = title;
			this.body = body;
		}
		
		public Integer getUserId() {
			return userId;
		}
		
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		
		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getBody() {
			return body;
		}
		
		public void setBody(String body) {
			this.body = body;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("userId");
			sb.append('=');
			sb.append(((this.userId == null)?"<null>":this.userId));
			sb.append(',');
			sb.append("id");
			sb.append('=');
			sb.append(((this.id == null)?"<null>":this.id));
			sb.append(',');
			sb.append("title");
			sb.append('=');
			sb.append(((this.title == null)?"<null>":this.title));
			sb.append(',');
			sb.append("body");
			sb.append('=');
			sb.append(((this.body == null)?"<null>":this.body));
			sb.append(',');
			if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
			} else {
			sb.append(']');
			}
			return sb.toString();
		}
}