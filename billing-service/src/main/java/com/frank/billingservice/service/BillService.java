package com.frank.billingservice.service;

import com.frank.billingservice.entities.Bill;
import com.frank.billingservice.feign.CustomerRestClient;
import com.frank.billingservice.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillService {
    private BillRepository billRepository;
    private CustomerRestClient customerRestClient;

    public List<Bill> getAllBills() {
        List<Bill> bills = billRepository.findAll();
        bills.forEach(bill -> {
            bill.setCustomer(customerRestClient.getCustomerById(bill.getCustumerId()));
        });
        return bills;
    }

    public Bill getAllBillById(Long id) {
        return billRepository.findById(id).get();
    }

}
