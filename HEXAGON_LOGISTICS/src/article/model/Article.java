package article.model;

import java.util.Date;

public class Article {
	
	private Integer number;
	private Writer writer;
	private String title;
	private Date regDate;
	private Date modifiedDate;
	private int readCount;
	
	public Article(Integer number, Writer writer, String title, Date regDate, Date modifiedDate, int readCount) {
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.readCount= readCount;
		
	}

	public Integer getNumber() {
		return number;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	

}
