package model;

import java.io.Serializable;

public class TS_LX implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7574162634848132822L;

	private String lbdm;
	private String flbdm;
	private String lbmc;
	private String flbmc;
	private String fydm;
	private String sfjy;
	private Integer pxh;

	public TS_LX() {
	}

	public TS_LX(String lbdm, String lbmc, Integer pxh,String sfjy) {
		this.lbdm = lbdm;
		this.lbmc = lbmc;
		this.pxh = pxh;
		this.sfjy = sfjy;
	}

	public TS_LX(String lbdm, String flbdm, String lbmc, String flbmc,
			String fydm, String sfjy, Integer pxh) {
		super();
		this.lbdm = lbdm;
		this.flbdm = flbdm;
		this.lbmc = lbmc;
		this.flbmc = flbmc;
		this.fydm = fydm;
		this.sfjy = sfjy;
		this.pxh = pxh;
	}

	public String getLbdm() {
		return lbdm;
	}

	public void setLbdm(String lbdm) {
		this.lbdm = lbdm;
	}

	public String getFlbdm() {
		return flbdm;
	}

	public void setFlbdm(String flbdm) {
		this.flbdm = flbdm;
	}

	public String getLbmc() {
		return lbmc;
	}

	public void setLbmc(String lbmc) {
		this.lbmc = lbmc;
	}

	public String getFlbmc() {
		return flbmc;
	}

	public void setFlbmc(String flbmc) {
		this.flbmc = flbmc;
	}

	public String getFydm() {
		return fydm;
	}

	public void setFydm(String fydm) {
		this.fydm = fydm;
	}

	public String getSfjy() {
		return sfjy;
	}

	public void setSfjy(String sfjy) {
		this.sfjy = sfjy;
	}

	public Integer getPxh() {
		return pxh;
	}

	public void setPxh(Integer pxh) {
		this.pxh = pxh;
	}

}
