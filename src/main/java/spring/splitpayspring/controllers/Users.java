package spring.splitpayspring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.splitpayspring.dto.requests.PostExpenseDTO;
import spring.splitpayspring.dto.requests.SearchAndValidateDTO;
import spring.splitpayspring.dto.requests.SettleExpenseDTO;
import spring.splitpayspring.dto.responses.SingleOweDTO;
import spring.splitpayspring.dto.responses.SinglePersonalExpenseDTO;
import spring.splitpayspring.dto.responses.TotalExpenseDTO;

import java.util.List;

@RequestMapping("users")
public class Users {

    @GetMapping("expenses")
    @ResponseBody
    public List<SinglePersonalExpenseDTO> getPersonalExpenses(){

    }

    @GetMapping("owed")
    @ResponseBody
    public List<SingleOweDTO> getOwed(){

    }

    @GetMapping("owes")
    @ResponseBody
    public List<SingleOweDTO> getOwes(){

    }

    @GetMapping("owed")
    @ResponseBody
    public ResponseEntity setOwes(){

    }

    @GetMapping("total-expenses")
    @ResponseBody
    public TotalExpenseDTO getTotalExpenses(){

    }

    @PostMapping("expense")
    public ResponseEntity createExpense(@RequestBody PostExpenseDTO expense){

    }

    @PatchMapping("settle-expense")
    public ResponseEntity settleExpense(@RequestBody SettleExpenseDTO expense){

    }

    @PostMapping("expense/shared")
    public ResponseEntity createSharedExpense(@RequestBody SettleExpenseDTO expense){

    }

    @PostMapping("search")
    public ResponseEntity searchByUsername(@RequestBody SearchAndValidateDTO query){

    }
}
