package com.FinalProject.MaintenanceTracker.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.FinalProject.MaintenanceTracker.mapper.ReceiptMapper;
import com.FinalProject.MaintenanceTracker.model.Receipt;


@Controller
@RequestMapping("/receipts")
public class ReceiptController {


    private final ReceiptMapper receiptMapper;


    public ReceiptController(ReceiptMapper receiptMapper){
        this.receiptMapper = receiptMapper;
    }



    @GetMapping
    public String viewReceipts(Model model){

        List<Receipt> receipts = receiptMapper.findAll();

        model.addAttribute("receipts", receipts);

        return "receipt";
    }



    @GetMapping("/add")
    public String addReceipt(Model model){

        model.addAttribute("receipt", new Receipt());

        return "receiptAdd";
    }



    @PostMapping("/save")
    public String saveReceipt(@ModelAttribute Receipt receipt){

        receiptMapper.insert(receipt);

        return "redirect:/receipt";
    }

}