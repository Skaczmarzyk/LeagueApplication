package pl.lolapp.champions;

import java.io.Serializable;

public class Passive  implements Serializable {

	private String description;
	private Image image;
	private String name;
	private String sanitizedDescription;

	public String getDescription() {
		return description;
	}

	public Image getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public String getSanitizedDescription() {
		return sanitizedDescription;
	}

	@Override
	public String toString() {
		return getName();
	}
}