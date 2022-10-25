package com.example.sales_management.controller;

import com.example.sales_management.entyti.HoaDon;
import com.example.sales_management.model.HoaDonDto;
import com.example.sales_management.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/sales-management/hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;

    @PostMapping
    public ResponseEntity<HoaDon> postHoaDon(@Valid @RequestBody HoaDonDto hoaDonDto){
        return hoaDonService.postHoaDon(hoaDonDto);
    }
    @GetMapping
    public ResponseEntity<List<HoaDon>> listAllHoaDon(){
        return hoaDonService.listAllHoaDon();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HoaDon> updateHoaDon(@PathVariable(value = "id")Long id,
                                               @Valid @RequestBody HoaDonDto hoaDonDto){
        return hoaDonService.updateHoaDon(id,hoaDonDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HoaDon> deleteHoaDon(@PathVariable(value = "id")Long id){
        return hoaDonService.deleteHoaDon(id);
    }
}
