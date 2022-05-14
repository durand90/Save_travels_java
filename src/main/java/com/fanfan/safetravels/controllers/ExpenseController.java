package com.fanfan.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fanfan.safetravels.models.Expense;
import com.fanfan.safetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseServ;
	
	@GetMapping("/")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		
		List<Expense> expenses = expenseServ.allExpenses();
		
		model.addAttribute("expenses", expenses);
		return "expenses.jsp";
	}

	@PostMapping("/expense")
	public String addExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseServ.allExpenses();
			
			model.addAttribute("expenses", expenses);
			return "expenses.jsp";
		} else {
			
			expenseServ.createExpense(expense);
			return "redirect:/";
		}
	}
	
	 @RequestMapping("/expense/{id}/edit")
		 public String edit(@PathVariable("id") Long id, Model model) {
		        Expense expense = expenseServ.findExpense(id);
		        model.addAttribute("expense", expense);
	        return "edit.jsp";
	    }
	 
	 @RequestMapping(value="/expense/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            expenseServ.updateExpense(expense);
	            return "redirect:/";
	        }
	    }
	 
	 @RequestMapping(value="/expense/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        expenseServ.deleteExpense(id);
	        return "redirect:/";
	    }
	 
	 @RequestMapping("/expense/{id}/show")
	 public String show(@PathVariable("id") Long id, Model model) {
		 	Expense expense = expenseServ.findExpense(id);
		 	model.addAttribute("expense", expense);
		 return "show.jsp";
	 }
}
