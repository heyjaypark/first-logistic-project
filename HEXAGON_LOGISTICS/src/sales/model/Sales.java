package sales.model;

import java.sql.Date;

public class Sales {
	
	private int s_Num;
	private int p_No;
	private int s_Seoul;
	private int s_Suwon;
	private int s_Incheon;
	private Date s_Date;
	
	public Sales(int s_Num, int p_No, int s_Seoul, int s_Suwon, int s_Incheon, Date s_Date) {
		this.s_Num = s_Num;
		this.p_No = p_No;
		this.s_Seoul = s_Seoul;
		this.s_Suwon = s_Suwon;
		this.s_Incheon = s_Incheon;
		this.s_Date = s_Date;
	}

	public int getS_Num() {
		return s_Num;
	}

	public int getP_No() {
		return p_No;
	}

	public int getS_Seoul() {
		return s_Seoul;
	}

	public int getS_Suwon() {
		return s_Suwon;
	}

	public int getS_Incheon() {
		return s_Incheon;
	}

	public Date getS_Date() {
		return s_Date;
	}

}
