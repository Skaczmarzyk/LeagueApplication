package pl.lolapp.champions;


import java.io.Serializable;

public class Skin implements Serializable {
	private int id;
	private String name;
	private int num;
	private boolean chromas;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNum() {
		return num;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isChromas() {
		return chromas;
	}

	public void setChromas(boolean chromas) {
		this.chromas = chromas;
	}

	@Override
	public String toString() {
		return getId() + ": " + getName();
	}
}