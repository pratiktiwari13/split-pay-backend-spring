package spring.splitpayspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.splitpayspring.dto.ExpenseDTO;
import spring.splitpayspring.models.Expenses;
import spring.splitpayspring.models.Users;
import spring.splitpayspring.repositories.ExpensesRepository;

import java.util.List;

@Service
public class ExpensesService {

    ExpensesRepository expensesRepository;
    @Autowired
    public ExpensesService(ExpensesRepository expensesRepository){
        this.expensesRepository = expensesRepository;
    }

    public List<Expenses> getPersonalExpenses(Users user){
        return expensesRepository.findExpensesByFromUserIdAndToUserId(user,user);
    }

    public void createExpenses(Users fromUser,Users toUser, Long amount, String description){
        Expenses e = new Expenses();
        e.setFromUserId(fromUser);
        e.setToUserId(toUser);
        e.setAmount(amount);
        e.setDescription(description);
        // in case of a personal expense both from and to are same
        e.setIsOwing(fromUser != toUser);
        e.setIsPaid(false);
    }
    
}
