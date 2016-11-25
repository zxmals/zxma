package model;

import java.io.Serializable;

public class TS_RY implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String yhdm;
	private String fydm;
	private String yhbm;
	private String bgdh;
	private String sjh;

	public TS_RY(String yhdm, String fydm, String yhbm, String bgdh, String sjh) {
		super();
		this.yhdm = yhdm;
		this.fydm = fydm;
		this.yhbm = yhbm;
		this.bgdh = bgdh;
		this.sjh = sjh;
	}

	public TS_RY() {
	}

	public String getYhdm() {
		return yhdm;
	}

	public void setYhdm(String yhdm) {
		this.yhdm = yhdm;
	}

	public String getFydm() {
		return fydm;
	}

	public void setFydm(String fydm) {
		this.fydm = fydm;
	}

	public String getYhbm() {
		return yhbm;
	}

	public void setYhbm(String yhbm) {
		this.yhbm = yhbm;
	}

	public String getBgdh() {
		return bgdh;
	}

	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}

	public String getSjh() {
		return sjh;
	}

	public void setSjh(String sjh) {
		this.sjh = sjh;
	}

}
