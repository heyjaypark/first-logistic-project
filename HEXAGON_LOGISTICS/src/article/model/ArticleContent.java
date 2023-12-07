package  article.model;

public class ArticleContent {
	
	private Integer number;
	private String content;
	
	public ArticleContent(Integer number, String content) {
		this.number=number;
		this.content=content;
		
	}

	public Integer getNumber() {
		return number;
	}

	public String getContent() {
		return content;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
