package spring.splitpayspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.splitpayspring.models.Expenses;
import spring.splitpayspring.models.Users;
import spring.splitpayspring.repositories.ExpensesRepository;

import java.util.List;
import java.util.Optional;

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

    public Expenses getExpense(Long id) {
        Optional<Expenses> e = expensesRepository.findById(id);
        return e.isPresent()?e.get():null;
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
        expensesRepository.saveAndFlush(e);
    }

    public Long settleExpenses(Expenses expense,int amount) throws IllegalArgumentException{
        Long currentAmount = expense.getAmount();
        if(amount>currentAmount)
            throw new IllegalArgumentException("Paying amount cant be greater than current");
        else if(amount==currentAmount){
            expense.setIsPaid(true);
            expense.setIsOwing(false);
            return 0L;
        }
        else{
            Long remainingAmount = currentAmount - amount;
            expense.setAmount(remainingAmount);
            return remainingAmount;
        }
    }

    public void createSharedExpenses(List<Users> users,Long initialAmount){

    }

    public void getOwes(){

    }

    public void getOwed(){

    }

    public void getTotalExpenses(){

    }

}
