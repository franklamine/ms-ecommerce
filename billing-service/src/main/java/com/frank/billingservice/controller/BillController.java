package com.frank.billingservice.controller;

import com.frank.billingservice.entities.Bill;
import com.frank.billingservice.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BillController {
    private  final BillService billService;

    @GetMapping("/bills")
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/bills/{id}")
    public Bill getAllBills(@PathVariable Long id) {
        return billService.getAllBillById(id);
    }
}
