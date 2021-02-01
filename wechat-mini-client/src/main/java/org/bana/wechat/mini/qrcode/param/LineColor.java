package org.bana.wechat.mini.qrcode.param;

import java.io.Serializable;

public class LineColor implements Serializable {

	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 963692786955681286L;
	
	private int r = 0;
	private int g = 0;
	private int b = 0;
	
	
	public LineColor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	
	
	@Override
	public String toString() {
		return "LineColor [r=" + r + ", g=" + g + ", b=" + b + "]";
	}
}
