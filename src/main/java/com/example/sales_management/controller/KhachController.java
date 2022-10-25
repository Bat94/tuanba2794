package com.example.sales_management.controller;

import com.example.sales_management.entyti.Khach;
import com.example.sales_management.model.KhachDto;
import com.example.sales_management.service.KhachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/sales-management/khach")
public class KhachController {

    @Autowired
    private KhachService khachService;

    @PostMapping
    public ResponseEntity<Khach> postKhach(@Valid @RequestBody KhachDto khachDto){
        return khachService.postKhach(khachDto);
    }
    @GetMapping
    public ResponseEntity<List<Khach>> listAllKhach(){
        return khachService.listAllKhach();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Khach> updateKhach(@PathVariable(value = "id")Long id,
                                             @Valid @RequestBody KhachDto khachDto){
        return khachService.updateKhach(id,khachDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Khach> deleteKhach(@PathVariable(value = "id")Long id){
        return khachService.deleteKhach(id);
    }

}
