package pl.lolapp.champions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Block  implements Serializable {

	private List<BlockItem> items;
	private boolean recMath;
	private String type;
	private boolean recSteps;
	private float minSummonerLevel;
	private float maxSummonerLevel;
	private String showIfSummonerSpell;
	private String hideIfSummonerSpell;
	private String appendAfterSection;
	ArrayList<Object> visibleWithAllOf = new ArrayList<Object>();
	ArrayList<Object> hiddenWithAnyOf = new ArrayList<Object>();

	public List<BlockItem> getItems() {
		return items;
	}

	public String getType() {
		return type;
	}

	public boolean isRecMath() {
		return recMath;
	}

	public boolean isRecSteps() {
		return recSteps;
	}

	public float getMinSummonerLevel() {
		return minSummonerLevel;
	}

	public float getMaxSummonerLevel() {
		return maxSummonerLevel;
	}

	public String getShowIfSummonerSpell() {
		return showIfSummonerSpell;
	}

	public String getHideIfSummonerSpell() {
		return hideIfSummonerSpell;
	}

	public String getAppendAfterSection() {
		return appendAfterSection;
	}

	public ArrayList<Object> getVisibleWithAllOf() {
		return visibleWithAllOf;
	}

	public ArrayList<Object> getHiddenWithAnyOf() {
		return hiddenWithAnyOf;
	}

	@Override
	public String toString() {
		return getType();
	}
}