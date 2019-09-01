package pl.lolapp.champions;


import java.io.Serializable;

public class Info  implements Serializable {


	private int attack;
	private int defense;
	private int difficulty;
	private int magic;

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public int getMagic() {
		return magic;
	}

	@Override
	public String toString() {
		return "[" + getAttack() + "," + getMagic() + "," + getDefense() + "," + getDifficulty() + "]";
	}
}