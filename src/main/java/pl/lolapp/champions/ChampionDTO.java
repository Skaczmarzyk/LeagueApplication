package pl.lolapp.champions;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class ChampionDTO<string>
    {

        @JsonProperty(value = "type")
        public string Type;
        @JsonProperty(value = "version")
        public string Version;
        @JsonProperty(value = "format")
        public String format;
        @JsonProperty("data")
        public transient Map<String,Champion> data;
        @JsonProperty("keys")
        public transient Map<Integer,String> keys;

        public Map<Integer, String> getKeys() {
            return keys;
        }

        public void setKeys(Map<Integer, String> keys) {
            this.keys = keys;
        }

        public string getType() {
            return Type;
        }

        public void setType(string type) {
            Type = type;
        }

        public string getVersion() {
            return Version;
        }

        public void setVersion(string version) {
            Version = version;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public Map<String, Champion> getData() {
            return data;
        }

        public void setData(Map<String, Champion> data) {
            this.data = data;
        }
    }
