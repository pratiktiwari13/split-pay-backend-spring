package spring.splitpayspring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.splitpayspring.dto.requests.PostGroupExpenseDTO;
import spring.splitpayspring.dto.responses.SingleGroupAllDTO;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("groups")
public class Groups {
    @GetMapping("all")
    public List<SingleGroupAllDTO> getAllGroups(){

    }

    @GetMapping("{id}")
    public SingleGroupAllDTO getSingleGroup(@PathVariable("id") String id){

    }

    @PostMapping("expense")
    public ResponseEntity expense(@RequestBody PostGroupExpenseDTO expense){
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity create(){
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
