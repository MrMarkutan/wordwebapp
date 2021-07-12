package vision.integrity.wordwebgame.controllers;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vision.integrity.wordwebgame.domain.Words;
import vision.integrity.wordwebgame.services.GameCheckerService;

@Controller
public class IndexController {
    private final GameCheckerService gameCheckerService;

    public IndexController(GameCheckerService gameCheckerService) {
        this.gameCheckerService = gameCheckerService;
    }

//    @GetMapping({"", "/", "/index.html"})
//    private String getResults(){
//        return "index";
//    }

    @PostMapping(value = "/check",
                    consumes = {MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String checkWords(@RequestBody Words wordsList){
        Words correctWords = new Words();
        correctWords.setWords(gameCheckerService.checkList(wordsList.getWords()));
        Gson gson = new Gson();
        return gson.toJson(correctWords);
    }
}
