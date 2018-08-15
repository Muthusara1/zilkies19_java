package io.ztech.expensesapp.delegates;

import io.ztech.expensesapp.beans.Expense;
import io.ztech.expensesapp.beans.GroupPayment;
import io.ztech.expensesapp.beans.User;
import io.ztech.expensesapp.constants.DisplayConstants;
import io.ztech.expensesapp.exceptions.LoginFailedException;
import io.ztech.expensesapp.exceptions.UsernameAlreadyExistsException;
import io.ztech.expensesapp.dao.ExpenseDAO;

public class ExpenseDelegate {
	ExpenseDAO expenseDao;

	public ExpenseDelegate() {
		expenseDao = new ExpenseDAO();
	}

	public void signUp(User user) throws UsernameAlreadyExistsException {
		if (expenseDao.isExistingUserName(user.getUserName())) {
			throw new UsernameAlreadyExistsException(DisplayConstants.USERNAME_EXISTS);
		}
		expenseDao.signUp(user);

	}

	public User logIn(User user) throws LoginFailedException {
		User activeUser = expenseDao.logIn(user);
		if (activeUser == null) {
			throw new LoginFailedException(DisplayConstants.INVALID_USERNAME_PASSWORD);
		}
		return activeUser;
	}

	public void addNewExpense(Expense expense) {
		if(expense instanceof Expense)
		expenseDao.addNewExpense(expense);
		if(expense instanceof GroupPayment)
			expenseDao.addGroupExpense((GroupPayment)expense);
	}

	public User showAllExpense(User activeUser) {

		User user = expenseDao.showAllExpenses(activeUser);
		return user;
	}
	
	public User viewGroups(User activeUser) {
		User user = expenseDao.viewGroups(activeUser);
		return user;
	}
	
	public void createGroups(User activeUser) {
		expenseDao.createGroups(activeUser);
	}
	
	public void addExpenseMembers(GroupPayment groupPayment) {
		expenseDao.addExpenseMembers(groupPayment);
	}
}
