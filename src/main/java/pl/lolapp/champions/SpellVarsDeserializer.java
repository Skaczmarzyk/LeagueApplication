package pl.lolapp.champions;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.*;

public class SpellVarsDeserializer extends JsonDeserializer<SpellVars> {
    @Override
    public SpellVars deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        Object testValue=node.get("coeff");
        List<Double> coeff;
        JsonNode node2 =node.get("dyn");
        String dyn="brak";
        String ranksWith="brak";
        if(node.get("dyn")!=null)
        {
            dyn=node.get("dyn").asText();
        }
        String key= node.get("key").asText();
        String link=  node.get("link").asText();
        if(node.get("dyn")!=null)
        {
            ranksWith = node.get("ranksWith").asText();
        }


        if(testValue instanceof java.util.List)
        {
            coeff= (ArrayList<Double>)testValue;
        }
        else
        {
            coeff=new ArrayList<>();
            coeff.add(((JsonNode) testValue).asDouble());
        }

        return new SpellVars(coeff,dyn,key,link,ranksWith);
    }
}