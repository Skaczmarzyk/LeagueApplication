package pl.lolapp.champions;

import java.io.Serializable;

public class Image  implements Serializable {

	private transient String id;
	private String full;
	private String group;
	private int h;
	private String sprite;
	private int w;
	private int x;
	private int y;

	public String getFull() {
		return full;
	}

	public String getGroup() {
		return group;
	}

	public int getH() {
		return h;
	}

	public String getSprite() {
		return sprite;
	}

	public int getW() {
		return w;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return getSprite();
	}
}