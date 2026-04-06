package com.example.expense_tracker.service;

import com.example.expense_tracker.model.Expense;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseService {

    private static final String COLLECTION = "expenses";

    public String addExpense(Expense expense) throws Exception {

        Firestore db = FirestoreClient.getFirestore();

        db.collection(COLLECTION)
                .document(expense.getId())
                .set(expense);

        return "Expense Added";

    }

    public List<Expense> getExpenses() throws Exception {

        Firestore db = FirestoreClient.getFirestore();

        List<Expense> list = new ArrayList<>();

        Iterable<DocumentReference> docs = db.collection(COLLECTION).listDocuments();

        for (DocumentReference doc : docs) {

            DocumentSnapshot snap = doc.get().get();
            Expense e = snap.toObject(Expense.class);

            list.add(e);
        }

        return list;
    }

    public String deleteExpense(String id) {

        Firestore db = FirestoreClient.getFirestore();

        db.collection(COLLECTION).document(id).delete();

        return "Deleted";
    }
}