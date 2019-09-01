
package pl.lolapp.champions;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = SpellVarsDeserializer.class)
public class SpellVars implements Serializable {


	private List<Double> coeff=new ArrayList<>();
	private String dyn;
	private String key;
	private String link;
	private String ranksWith;

    public SpellVars(List<Double> coeff, String dyn, String key, String link, String ranksWith) {
        this.coeff = coeff;
        this.dyn = dyn;
        this.key = key;
        this.link = link;
        this.ranksWith = ranksWith;
    }

    public void setCoeff(double coeff) {
		this.coeff.add(coeff);
	}

	public List<Double> getCoeff() {
		return coeff;
	}

	public void setCoeff(List<Double> coeff) {
		this.coeff = coeff;
	}

	public String getDyn() {
		return dyn;
	}

	public String getKey() {
		return key;
	}

	public String getLink() {
		return link;
	}

	public String getRanksWith() {
		return ranksWith;
	}

	@Override
	public String toString() {
		return getKey();
	}
}