package org.stud_life;

import ch.qos.logback.core.model.Model;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/"})
public class RestController{
    private static ObjectMapper mapper = new ObjectMapper();
    @RequestMapping({"/auth", "/auth/"})
    public String auth(Model model) throws Exception{
        JsonNode node = mapper.readTree(model.getBodyText());
        System.out.println(node);
        return "";
    }
}