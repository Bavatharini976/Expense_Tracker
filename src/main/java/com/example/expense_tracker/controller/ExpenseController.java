package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> getAll() {
        return service.getExpenses();
    }

    @PostMapping
    public String add(@RequestBody Expense expense) {
        return service.addExpense(expense);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return service.deleteExpense(id);
    }
}