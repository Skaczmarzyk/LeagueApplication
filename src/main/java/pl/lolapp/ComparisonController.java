package pl.lolapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lolapp.champions.Champion;
import pl.lolapp.champions.ChampionDTO;
import pl.lolapp.static_data.StaticDataService;

import javax.servlet.ServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ComparisonController {

    private ChampionDTO championDTO;
    private StaticDataService staticDataService;
    private Champion[] championsComparison= new Champion[3];

    @Autowired
    public ComparisonController(StaticDataService staticDataService)
    {
        this.staticDataService=staticDataService;
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            this.championDTO=(mapper.readValue(new File(staticDataService.getChampionsPath()), ChampionDTO.class));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    @ModelAttribute("championList")
    public Map<String,String> returnAllChampions()
    {
            return championDTO.keys;
    }

    @RequestMapping (path= "/championComp", method = RequestMethod.GET)
    public String compareChampions(@RequestParam(name = "champion" ,required = false) String champion, Model model)
    {
       if(champion!=null)
        {
            championsComparison[2]=championsComparison[1];
            championsComparison[1]=championsComparison[0];
            championsComparison[0]=(Champion)championDTO.data.get(champion);
            model.addAttribute("spells","dragontail-"+StaticDataService.getCurrentVersion()+"/"+StaticDataService.getCurrentVersion()+"/img/spell/");
            model.addAttribute("champ1splash","dragontail-"+StaticDataService.getCurrentVersion()+"/img/champion/loading/"+championsComparison[0].getId()+"_0.jpg");
            model.addAttribute("champion1",championsComparison[0]);
            if(championsComparison[1]!=null)
            {
                model.addAttribute("champ2splash","dragontail-"+StaticDataService.getCurrentVersion()+"/img/champion/loading/"+championsComparison[1].getId()+"_0.jpg");
                model.addAttribute("champion2",championsComparison[1]);
            }
        }
        return "championComp";
    }
}
