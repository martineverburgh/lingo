package nl.ITAcademy.project.LINGO.controller;

import nl.ITAcademy.project.LINGO.LINGO;
import nl.ITAcademy.project.LINGO.WoordenChecker;
import nl.ITAcademy.project.LINGO.model.Player;
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

    @GetMapping("/validate")
    public boolean checkValidInput(@RequestParam("input") String input){
        return lingo.isValidWord(input.toLowerCase());
    }

    @GetMapping("/checkInput")
    public String[] getInputAndReturnLocationInfo(@RequestParam("input") String input) {
        return lingo.checkInput(input);
    }
}
