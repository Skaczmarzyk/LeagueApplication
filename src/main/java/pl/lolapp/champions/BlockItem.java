package pl.lolapp.champions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockItem implements Serializable {

	private int count;
	private int id;
	private boolean hideCount;

	public int getCount() {
		return count;
	}

	public int getId() {
		return id;
	}

	public boolean isHideCount() {
		return hideCount;
	}

	@Override
	public String toString() {
		return getId() + ": " + getCount();
	}
}