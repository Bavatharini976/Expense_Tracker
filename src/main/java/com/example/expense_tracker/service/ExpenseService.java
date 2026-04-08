package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> getExpenses() throws Exception {
        return service.getAllExpenses();
    }

    @PostMapping
    public void addExpense(@RequestBody Expense expense) {
        service.addExpense(expense);
    }
}