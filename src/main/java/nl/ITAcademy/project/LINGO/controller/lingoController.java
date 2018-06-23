package nl.ITAcademy.project.LINGO.controller;

import nl.ITAcademy.project.LINGO.LINGO;
import nl.ITAcademy.project.LINGO.WoordenChecker;
import nl.ITAcademy.project.LINGO.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lingo")
public class lingoController {

    @Autowired
    WoordenChecker lingo = new WoordenChecker();

    @GetMapping("/start")
    public void startLingo(){
        lingo.pickRandomWord();
    }

    @GetMapping
    public String[] getInputAndReturnLocationInfo(@PathVariable(value = "input") String input) {
        return lingo.checkInput(input);
    }
}
