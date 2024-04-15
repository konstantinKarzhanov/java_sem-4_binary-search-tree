package com.keyin.controller;

import com.keyin.model.BinarySearchTree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class BinarySearchTreeController {
    private final BinarySearchTree binarySearchTree;

    public BinarySearchTreeController(BinarySearchTree binarySearchTree) {
        this.binarySearchTree = binarySearchTree;
    }

    @GetMapping("enter-numbers")
    public String getEnterNumbersView() {
        return "enter-numbers";
    }

    @GetMapping("process-numbers")
    public String getProcessNumbersView(Model model) {
        model.addAttribute("binarySearchTree", this.binarySearchTree);
        return "process-numbers";
    }

    @PostMapping("process-numbers")
    public String postProcessNumbersView(@RequestParam("numbers") String numberStr) {
        List<Integer> numberList = this.binarySearchTree.createListOfNumbersFromString(numberStr);

        this.binarySearchTree.insertNumbers(numberList);

        return "redirect:process-numbers";
    }

    @GetMapping("search-number")
    public String getSearchNumberView() {
        return "search-number";
    }

    @PostMapping("search-number")
    public String postSearchNumberView(@RequestParam("number") int number, Model model) {
        model.addAttribute("number", number);
        model.addAttribute("isNumberExist", this.binarySearchTree.isNumberExist(number));

        return "search-number";
    }
}
