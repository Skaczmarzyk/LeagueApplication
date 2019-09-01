package pl.lolapp.champions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recommended  implements Serializable {

	private List<Block> blocks;
	private String champion;
	private String map;
	private String mode;
	private boolean priority;
	private String title;
	private String type;
	private String customTag;
	private int sortrank;
	private boolean extensionPage;
	private boolean useObviousCheckmark;
	private String customPanel;
	private String requiredPerk;
	private String customPanelCurrencyType;
	private String customPanelBuffCurrencyName;

	public List<Block> getBlocks() {
		return blocks;
	}

	public String getChampion() {
		return champion;
	}

	public String getMap() {
		return map;
	}

	public String getMode() {
		return mode;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public boolean isPriority() {
		return priority;
	}

	public String getCustomPanelCurrencyType() {
		return customPanelCurrencyType;
	}

	public String getCustomPanelBuffCurrencyName() {
		return customPanelBuffCurrencyName;
	}

	public String getCustomTag() {
		return customTag;
	}

	public String getRequiredPerk() {
		return requiredPerk;
	}

	public int getSortrank() {
		return sortrank;
	}

	public boolean isExtensionPage() {
		return extensionPage;
	}

	public boolean isUseObviousCheckmark() {
		return useObviousCheckmark;
	}

	public String getCustomPanel() {
		return customPanel;
	}

	@Override
	public String toString() {
		return getTitle();
	}
}