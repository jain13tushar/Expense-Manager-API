package in.selfproject.expensetrackerapi.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.selfproject.expensetrackerapi.entity.Expense;
import in.selfproject.expensetrackerapi.service.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/expenses")
	public List<Expense> getAllExpenses(Pageable page) {
		return expenseService.getAllExpenses(page).toList();
	}

	@GetMapping("/expense/{id}")
	public Expense getAllExpenseById(@PathVariable(name = "id") Long id) {
		return expenseService.getExpenseById(id);
	}

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/deleteExpense")
	public void deleteExpenseById(@RequestParam(name = "id") Long id) {
		expenseService.deleteExpenseById(id);
	}

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/saveExpense")
	public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
		return expenseService.saveExpenseDetails(expense);
	}

	@PutMapping("/updateExpense/{id}")
	public Expense updateExpenseDetails(@PathVariable Long id, @RequestBody Expense expense) {
		return expenseService.updateExpenseDetails(id, expense);
	}

	@PutMapping("/expensesCategory")
	public List<Expense> getExpensesByCategory(@RequestParam String category, Pageable page) {
		return expenseService.readByCategory(category, page);
	}

	@GetMapping("/expensesName")
	public List<Expense> getExpensesByName(@RequestParam String keyword, Pageable page) {
		return expenseService.readByName(keyword, page);
	}

	@GetMapping("/expensesDate")
	public List<Expense> getExpensesByDates(@RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate, Pageable page) {
		return expenseService.readByDate(startDate, endDate, page);
	}
}
