package com.project.passwordmanager.controllers.harry;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class hfrq9controller {
    @GetMapping("/harry/frq9")
    public String frq9q1(@RequestParam(name = "title", required = false, defaultValue = "Peter and Wendy") String title,
                         @RequestParam(name = "author", required = false, defaultValue = "J.M. Barrie") String author,
                         @RequestParam(name = "illustrator", required = false, defaultValue = "F.D. Bedford") String illustrator,
                         @RequestParam(name = "libauth", required = false, defaultValue = "Marry Shelley") String libauth,
                         @RequestParam(name = "lib", required = false, defaultValue = "Frankenstein") String lib,
                         @RequestParam(name = "price1", required = false, defaultValue = "10") String price1,
                         @RequestParam(name = "price2", required = false, defaultValue = "12") String price2,Model model) throws IOException {


        PictureBook parta = new PictureBook(title, author, illustrator);
        String a = parta.printBookInfo();

        model.addAttribute("a", a );

        //question b
        String list =" ";
        Book book1 = new Book(lib, libauth);
        String book2 = book1.printBookInfo();
        ArrayList<String> myLibrary = new ArrayList<String>();
        myLibrary.add(book2);
        myLibrary.add(a);
        for(String i:myLibrary){
            list=list + i+"; ";
        }
        model.addAttribute("b", list );

//part c
        BookListing info = new BookListing(book2,Integer.parseInt(price1));
        String c1=info.printDescription();
        BookListing info2=new BookListing(a, Integer.parseInt(price2));
        String c2=info2.printDescription();
        model.addAttribute("c1",c1);
        model.addAttribute("c2",c2);


        return "frqs/harryfrq9";
    }
    @GetMapping("/harry/code9")
    public String frqcode(){
        return "frqs/frq9code";
    }

    @GetMapping("/harry/frq9b")
    public String frqb( @RequestParam(name = "name", required = false, defaultValue = "Lisa") String name,
                        @RequestParam(name = "specie", required = false, defaultValue = "Lion") String specie,
                        @RequestParam(name = "food", required = false, defaultValue = "carnivore") String food,
                        @RequestParam(name = "name2", required = false, defaultValue = "Gary") String name2,
                        @RequestParam(name = "specie2", required = false, defaultValue = "Giraffe") String specie2,
                        @RequestParam(name = "name3", required = false, defaultValue = "Giraffe") String name3,
                        @RequestParam(name = "length", required = false, defaultValue = "2.0") double  length,Model model) throws IOException{

  Animal animal =new Animal(food, specie, name);
  String info=animal.toString();
  model.addAttribute("a", info);

  Herbivore herbivore= new Herbivore(specie2, name2);
  String info2=herbivore.toString();
  model.addAttribute("b", info2);

  Elephant elephant = new Elephant(name3, length);
  String info3=elephant.toString();
  model.addAttribute("c",info3);

        return "frqs/harryfrq9b";
    }
}
