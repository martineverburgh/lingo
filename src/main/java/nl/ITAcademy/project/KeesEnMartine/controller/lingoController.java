package nl.ITAcademy.project.KeesEnMartine.controller;

import nl.ITAcademy.project.KeesEnMartine.WoordenChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lingo")
public class lingoController {

    @Autowired
    WoordenChecker lingo = new WoordenChecker();

    @GetMapping("/start")
    public String getFirstLetter(){
        lingo.pickRandomWord();
        return lingo.getWord().substring(0,1);
    }

    @GetMapping("/answer")
    public String getCorrectAnswer(){
        return lingo.getWord();
    }

    @GetMapping("/validate")
    public boolean checkValidInput(@RequestParam("input") String input){
        return lingo.isValidWord(input.toLowerCase());
    }

    @GetMapping("/checkInput")
    public String[] getInputAndReturnLocationInfo(@RequestParam("input") String input) {
        return lingo.checkInput(input);
    }
}
