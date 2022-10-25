package com.example.sales_management.controller;

import com.example.sales_management.entyti.Hang;
import com.example.sales_management.model.HangDto;
import com.example.sales_management.service.HangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/sales-management/hang")
public class HangController {
    @Autowired
    private HangService hangService;

    @PostMapping
    public ResponseEntity<Hang> postHang(@Valid @RequestBody HangDto hangDto){

        return hangService.postHang(hangDto);
    }

    @GetMapping
    public ResponseEntity<List<Hang>> listAllHang(){
        return hangService.listAllHang();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hang> updateHang(@PathVariable (value = "id")Long id,
                                           @Valid @RequestBody HangDto hangDto){
        return hangService.updateHang(id,hangDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Hang> deleteHang(@PathVariable(value = "id")Long id){
        return hangService.deleteHang(id);
    }
}
