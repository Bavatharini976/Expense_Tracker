package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.service.ExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/expenses")
@CrossOrigin(origins = "*")

public class ExpenseController {

    @Autowired
    ExpenseService service;

    @GetMapping
    public List<Expense> getExpenses() throws Exception {
        return service.getExpenses();
    }

    @PostMapping
    public String addExpense(@RequestBody Expense expense) throws Exception {
        return service.addExpense(expense);
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable String id) {
        return service.deleteExpense(id);
    }
}