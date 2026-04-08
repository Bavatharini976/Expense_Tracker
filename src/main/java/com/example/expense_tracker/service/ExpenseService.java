package com.example.expense_tracker.service;

import com.example.expense_tracker.model.Expense;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ExpenseService {

    // 🔴 REPLACE WITH YOUR FIREBASE URL
    private final String FIREBASE_URL = "https://expense-tracker-d18aa-default-rtdb.firebaseio.com/expenses";

    private final RestTemplate restTemplate = new RestTemplate();

    // ✅ ADD EXPENSE
    public String addExpense(Expense expense) {

        String url = FIREBASE_URL + ".json";

        // Firebase auto-generates unique ID
        Map<String, String> response = restTemplate.postForObject(url, expense, Map.class);

        if (response != null && response.get("name") != null) {
            expense.setId(response.get("name"));
        }

        return "Expense added";
    }

    // ✅ GET ALL EXPENSES
    public List<Expense> getExpenses() {

        String url = FIREBASE_URL + ".json";

        Map<String, Map<String, Object>> data =
                restTemplate.getForObject(url, Map.class);

        List<Expense> list = new ArrayList<>();

        if (data != null) {
            for (Map.Entry<String, Map<String, Object>> entry : data.entrySet()) {

                Expense exp = new Expense();

                exp.setId(entry.getKey());
                exp.setTitle((String) entry.getValue().get("title"));
                exp.setAmount(Double.parseDouble(entry.getValue().get("amount").toString()));

                list.add(exp);
            }
        }

        return list;
    }

    // ✅ DELETE EXPENSE
    public String deleteExpense(String id) {

        String url = FIREBASE_URL + "/" + id + ".json";

        restTemplate.delete(url);

        return "Expense deleted";
    }
}