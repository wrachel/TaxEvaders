package com.project.passwordmanager.controllers.rachel;

import com.project.frqs.rachel.rachel_Invitation;
import com.project.frqs.rachel.rachelfrq4;
import com.project.frqs.rachel.rachelfrq5q2;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

import com.project.frqs.rachel.rachelfrq7;
import com.project.frqs.rachel.rachelfrq6;
import com.project.frqs.rachel.frq9.rachelBook;
import com.project.frqs.rachel.frq9.RachelPictureBook;
import com.project.frqs.rachel.frq9.rachelBookListing;
import com.project.frqs.rachel.frq9.rachelAnimal;
import com.project.frqs.rachel.frq9.rachelElephant;
import com.project.frqs.rachel.frq9.rachelHerbivore;

@Controller
public class rachController {
    /*@GetMapping("/rachel/frq6")
    public String rachelfrq5(@RequestParam(name = "words", required = false, defaultValue = "ten, fading, post, card, thunder, hinge, trailing, batting") ArrayList<String> words, Model model) {
        rachelfrq6 ing = new rachelfrq6(words);
        model.addAttribute("returnStatement", (ing.returnvalue(words)));
        return "/frqs/rachel/rachelfrq6";
    }
     */

    @GetMapping("/rachel/frq6")
    public String rachelfrq6(){
        return "frqs/rachel/rachelfrq6";
    }

    @GetMapping("/rachel/frq7")
    public String rachelfrq7(@RequestParam(name="firstName", required = false, defaultValue = "Rachel")String firstName, @RequestParam(name="lastName", required = false, defaultValue = "Wei")String lastName, Model model){
        rachelfrq7 randomUsername = new rachelfrq7(firstName, lastName);
        model.addAttribute("username", randomUsername.randomUsername());
        return "frqs/rachel/rachelfrq7";
    }

    @GetMapping("/rachel/frq9")
    public String rachelfrq9(@RequestParam(name="title", required = true, defaultValue = "Frankenstein")String title, @RequestParam(name="author", required = true, defaultValue = "Mary Shelley")String author, @RequestParam(name="illustrator", required = false)String illustrator, @RequestParam(name="price", required = false)Double price,
                             @RequestParam(name="animalName", required = true, defaultValue = "gary")String animalName, @RequestParam(name="elephant", required = false, defaultValue = "false")Boolean elephant, @RequestParam(name="species", required = false, defaultValue = "dog")String species, @RequestParam(name="notHerbivore", required = false, defaultValue = "omnivore")String notHerbivore, @RequestParam(name="herbivore", required = false, defaultValue = "false")Boolean herbivore, @RequestParam(name="tusk", required = false, defaultValue = "5.0")double tusk, Model model){
        //question 1 begins here
        if(price == null && illustrator == null){
            rachelBook FirstBook = new rachelBook(title, author);
            model.addAttribute("returnstatement", FirstBook.toString());
        }

        else if(illustrator == null && !(price == null)){
            rachelBookListing ThirdBook = new rachelBookListing(title, author, price);
            model.addAttribute("returnstatement", ThirdBook.toString());
        }
        else if(price == null && !(illustrator == null)){
            RachelPictureBook SecondBook = new RachelPictureBook(title, author, illustrator);
            model.addAttribute("returnstatement", SecondBook.toString());
        }

        else if(!(price == null) && !(illustrator == null)){
            RachelPictureBook SecondBook = new RachelPictureBook(title, author, illustrator);
            model.addAttribute("returnstatement", SecondBook.toString());

            rachelBookListing ThirdBook = new rachelBookListing(title, author, price);
            model.addAttribute("returnstatement1", ThirdBook.toString());
        }
        // Question 2 begins here
        if(!(elephant == null) && !(herbivore == null)){
            rachelElephant newElephant = new rachelElephant(animalName, tusk);
            model.addAttribute("returnAnimal", newElephant.toString());
        }
        else if(!(herbivore == null)){
            rachelHerbivore newHerbivore = new rachelHerbivore(species, animalName);
            model.addAttribute("returnAnimal", newHerbivore.toString());
        }
        else{
            rachelAnimal newAnimal = new rachelAnimal(notHerbivore, species, animalName);
            model.addAttribute("returnAnimal", newAnimal.toString());
        }

        return "/frqs/rachel/rachelfrq9";
    }

}