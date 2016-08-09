package model;

import java.io.Serializable;

public class T_USER implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1353070513141309366L;

	private String YHDM;
	private String DWDM;
	private String YHID;
	private String YHXM;
	private String YHKL;
	private String YHXB;
	private String YHBM;
	private String CSRQ;
	private int PXH;
	private String SFJY;
	private String BMMC;

	public T_USER(String yHDM, String dWDM, String yHID, String yHXM,
			String yHKL, String yHXB, String yHBM, String cSRQ, int pXH,
			String sFJY) {
		YHDM = yHDM;
		DWDM = dWDM;
		YHID = yHID;
		YHXM = yHXM;
		YHKL = yHKL;
		YHXB = yHXB;
		YHBM = yHBM;
		CSRQ = cSRQ;
		PXH = pXH;
		SFJY = sFJY;
	}

	public T_USER(String yHDM, String yHXM, String yHBM, String bMMC) {
		super();
		YHDM = yHDM;
		YHXM = yHXM;
		YHBM = yHBM;
		BMMC = bMMC;
	}

	public T_USER(String yHXM, String yHID, String yHKL, String yHBM,
			String bMMC) {
		YHXM = yHXM;
		YHKL = yHKL;
		YHID = yHID;
		YHBM = yHBM;
		BMMC = bMMC;
	}

	public T_USER() {
		// TODO Auto-generated constructor stub
	}

	public String getBMMC() {
		return BMMC;
	}

	public void setBMMC(String bMMC) {
		BMMC = bMMC;
	}

	public String getYHDM() {
		return YHDM;
	}

	public void setYHDM(String yHDM) {
		YHDM = yHDM;
	}

	public String getDWDM() {
		return DWDM;
	}

	public void setDWDM(String dWDM) {
		DWDM = dWDM;
	}

	public String getYHID() {
		return YHID;
	}

	public void setYHID(String yHID) {
		YHID = yHID;
	}

	public String getYHXM() {
		return YHXM;
	}

	public void setYHXM(String yHXM) {
		YHXM = yHXM;
	}

	public String getYHKL() {
		return YHKL;
	}

	public void setYHKL(String yHKL) {
		YHKL = yHKL;
	}

	public String getYHXB() {
		return YHXB;
	}

	public void setYHXB(String yHXB) {
		YHXB = yHXB;
	}

	public String getYHBM() {
		return YHBM;
	}

	public void setYHBM(String yHBM) {
		YHBM = yHBM;
	}

	public String getCSRQ() {
		return CSRQ;
	}

	public void setCSRQ(String cSRQ) {
		CSRQ = cSRQ;
	}

	public int getPXH() {
		return PXH;
	}

	public void setPXH(int pXH) {
		PXH = pXH;
	}

	public String getSFJY() {
		return SFJY;
	}

	public void setSFJY(String sFJY) {
		SFJY = sFJY;
	}

}
