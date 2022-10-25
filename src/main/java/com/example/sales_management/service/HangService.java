package com.example.sales_management.service;

import com.example.sales_management.entyti.Hang;
import com.example.sales_management.model.HangDto;
import com.example.sales_management.repository.HangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangService {
    @Autowired
    private HangRepository hangRepository;

    public ResponseEntity<Hang> postHang(HangDto hangDto) {
        Hang hang = new Hang();
        hang.setTenHang(hangDto.getTenHang());
        hang.setDonGia(hangDto.getDonGia());
        hang.setDonVi(hangDto.getDonVi());
        hangRepository.save(hang);
        return ResponseEntity.ok(hang);
    }

    public ResponseEntity<List<Hang>> listAllHang() {
        List<Hang> listHang = hangRepository.findAll();
        if(listHang.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listHang);
    }

    public ResponseEntity<Hang> updateHang(Long id, HangDto hangDto) {
        Hang hang = hangRepository.getOne(id);
        if(hang == null){
            return ResponseEntity.notFound().build();
        }
        hang.setTenHang(hangDto.getTenHang());
        Hang updateHang = hangRepository.save(hang);
        return ResponseEntity.ok(updateHang);
    }

    public ResponseEntity<Hang> deleteHang(Long id) {
        Hang hang = hangRepository.getOne(id);
        if(hang == null){
            return ResponseEntity.notFound().build();
        }
        hangRepository.delete(hang);
        return ResponseEntity.ok().build();
    }
}
