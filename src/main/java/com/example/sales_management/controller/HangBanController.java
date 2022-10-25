package com.example.sales_management.controller;

import com.example.sales_management.entyti.HangBan;
import com.example.sales_management.model.HangBanDto;
import com.example.sales_management.model.HangDto;
import com.example.sales_management.service.HangBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/sales-management/hang-ban")
public class HangBanController {

    @Autowired
    private HangBanService hangBanService;

    @PostMapping
    public ResponseEntity<HangBan> postHangBan(@Valid @RequestBody HangBanDto hangBanDto){
        return hangBanService.postHangBan(hangBanDto);
    }
    @GetMapping
    public ResponseEntity<List<HangBan>> listAllHangBan(){
        return hangBanService.listAllHangBan();
    }
    @PutMapping("/{id}")
    public ResponseEntity<HangBan> updateHangBan(@PathVariable (value = "id")Long id,
                                                 @Valid @RequestBody HangBanDto hangBanDto){
        return hangBanService.updateHangBan(id,hangBanDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HangBan> deleteHangBan(@PathVariable(value = "id")Long id){
        return hangBanService.deleteHangBan(id);
    }
}
