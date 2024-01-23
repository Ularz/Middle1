package tw.pic.xuan;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;

public class picMember implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int picid;
	private String imageName;
	private byte[] ftent;
	private InputStream imageStream;

	public picMember() {

	}

	public picMember(int picid, String imageName, byte[] ftent) {

		this.picid = picid;
		this.imageName = imageName;
		this.ftent = ftent;
	}

	public picMember(String imageName, byte[] ftent) {

		this.imageName = imageName;
		this.ftent = ftent;
	}

	public picMember(String imageName, InputStream imageStream) {
		this.imageName = imageName;
		this.imageStream = imageStream;
	}

	public picMember(String string, FileInputStream fileinput) {
		// TODO Auto-generated constructor stub
	}

	public int getPicid() {
		return picid;
	}

	public void setPicid(int picid) {
		this.picid = picid;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getFtent() {
		return ftent;
	}

	public void setFtent(byte[] ftent) {
		this.ftent = ftent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}

}
