package pl.lolapp.champions;

import java.io.Serializable;
import java.util.List;

public class LevelTip implements Serializable {


	private List<String> effect;
	private List<String> label;

	public List<String> getEffect() {
		return effect;
	}

	public List<String> getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return getLabel().toString();
	}
}