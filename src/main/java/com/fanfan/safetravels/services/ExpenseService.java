package com.fanfan.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanfan.safetravels.models.Expense;
import com.fanfan.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository ExpenseRepo;
	
    public List<Expense> allExpenses() {
        return ExpenseRepo.findAll();
    }
    // creates a book
    public Expense createExpense(Expense b) {
        return ExpenseRepo.save(b);
    }
    // retrieves a book
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = ExpenseRepo.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
	public void deleteExpense(Long id) {
		// TODO Auto-generated method stub
		ExpenseRepo.deleteById(id);
	}
		
//	public Expense updateExpense(Long id, String name, String vendor, double amount, String description) {
//		// TODO Auto-generated method stub
//		Expense expense = findExpense(id);
//		expense.setName(name);
//		expense.setVendor(vendor);
//		expense.setAmount(amount);
//		expense.setDescription(description);
//		return ExpenseRepo.save(expense);
//	}
	
	public Expense updateExpense(Expense b) {
		return ExpenseRepo.save(b);
	}

}
