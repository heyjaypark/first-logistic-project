package article.service;

import java.util.Map;

public class ModifyRequest {
	
	private String userId;
	private int articleNumber;
	private String title;
	private String content;
	
	public ModifyRequest(String userId, int articleNumber, String title, String content) {
		this.userId=userId;
		this.articleNumber=articleNumber;
		this.title=title;
		this.content=content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public void validate(Map<String,Boolean>errors) {
		if(title==null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}

}
