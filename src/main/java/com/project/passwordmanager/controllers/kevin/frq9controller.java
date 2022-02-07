package com.project.passwordmanager.controllers.kevin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

@Controller
public class frq9controller {
    @GetMapping("/kevin/unit9/interactive")
    public String displayFRQInteractive(Model model,
                                        @RequestParam(name = "title", required = false, defaultValue = "Peter and Wendy") String title,
                                        @RequestParam(name = "author", required = false, defaultValue = "J.M. Barrie") String author,
                                        @RequestParam(name = "illustrator", required = false, defaultValue = "") String illustrator,
                                        @RequestParam(name = "price", required = false, defaultValue = "") String price
    ) {

        if(Objects.equals(illustrator, "")){
            Book book = new Book(title, author);
            if(price.equals("")) {
                model.addAttribute("book", book.printBookInfo());
            } else {
                BookListing booklisting1 = new BookListing(book, Double.parseDouble(price));
                model.addAttribute("book", booklisting1.printDescription());
            }

        } else {
            PictureBook book = new PictureBook(title, author, illustrator);
            if(price.equals("")) {
                model.addAttribute("book", book.printBookInfo());
            } else {
                BookListing booklisting1 = new BookListing(book, Double.parseDouble(price));
                model.addAttribute("book", booklisting1.printDescription());
            }

        }

        return "frontend/kevin/unit9interactive";
    }
}
