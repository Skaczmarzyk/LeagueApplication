/*
 * Copyright 2015 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.lolapp.champions;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import java.io.Serializable;

public class Stats implements Serializable {

	private double armor;
	@JsonProperty(value = "armorperlevel")
	private double armorPerLevel;
	@JsonProperty(value = "attackdamage")
	private double attackDamage;
	@JsonProperty(value = "attackdamageperlevel")
	private double attackDamagePerLevel;
	@JsonProperty(value = "attackrange")
	private double attackRange;
	private double attackSpeedOffset;
	@JsonProperty(value = "attackspeedperlevel")
	private double attackSpeedPerLevel;
	@JsonProperty(value = "attackspeed")
	private double attackSpeed;
	private double crit;
	@JsonProperty(value = "critperlevel")
	private double critPerLevel;
	private double hp;
	@JsonProperty(value = "hpperlevel")
	private double hpPerLevel;
	@JsonProperty(value = "hpregen")
	private double hpRegen;
	@JsonProperty(value = "hpregenperlevel")
	private double hpRegenPerLevel;
	@JsonProperty(value = "movespeed")
	private double moveSpeed;
	private double mp;
	@JsonProperty(value = "mpperlevel")
	private double mpPerLevel;
	@JsonProperty(value = "mpregen")
	private double mpregen;
	@JsonProperty(value = "mpregenperlevel")
	private double mpRegenPerLevel;
	@JsonProperty(value = "spellblock")
	private double spellBlock;
	@JsonProperty(value = "spellblockperlevel")
	private double spellBlockPerLevel;

	public double getArmor() {
		return armor;
	}

	public double getArmorPerLevel() {
		return armorPerLevel;
	}

	public double getAttackDamage() {
		return attackDamage;
	}

	public double getAttackDamagePerLevel() {
		return attackDamagePerLevel;
	}

	public double getAttackRange() {
		return attackRange;
	}

	public double getAttackSpeedOffset() {
		return attackSpeedOffset;
	}

	public double getAttackSpeedPerLevel() {
		return attackSpeedPerLevel;
	}


	public double getCrit() {
		return crit;
	}

	public double getCritPerLevel() {
		return critPerLevel;
	}

	public double getHp() {
		return hp;
	}

	public double getHpPerLevel() {
		return hpPerLevel;
	}

	public double getHpRegen() {
		return hpRegen;
	}

	public double getHpRegenPerLevel() {
		return hpRegenPerLevel;
	}

	public double getMoveSpeed() {
		return moveSpeed;
	}

	public double getMp() {
		return mp;
	}

	public double getMpPerLevel() {
		return mpPerLevel;
	}

	public double getMpregen() {
		return mpregen;
	}

	public double getMpRegenPerLevel() {
		return mpRegenPerLevel;
	}

	public double getSpellBlock() {
		return spellBlock;
	}

	public double getSpellBlockPerLevel() {
		return spellBlockPerLevel;
	}


	public double getAttackSpeed() {
		return attackSpeed;
	}

}