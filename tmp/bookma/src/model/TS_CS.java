package model;

import java.io.Serializable;

public class TS_CS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7619645291785269151L;

	private String kind;
	private String fydm;
	private Integer code;

	public TS_CS(String kind, String fydm, Integer code) {
		super();
		this.kind = kind;
		this.fydm = fydm;
		this.code = code;
	}

	public TS_CS() {
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getFydm() {
		return fydm;
	}

	public void setFydm(String fydm) {
		this.fydm = fydm;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
