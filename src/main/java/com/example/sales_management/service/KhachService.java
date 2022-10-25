package com.example.sales_management.service;

import com.example.sales_management.entyti.Khach;
import com.example.sales_management.model.KhachDto;
import com.example.sales_management.repository.KhachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachService {

    @Autowired
    private KhachRepository khachRepository;

    public ResponseEntity<Khach> postKhach(KhachDto khachDto) {
        Khach khach = new Khach();
        khach.setTenKhach(khachDto.getTenKhach());
        khach.setDiaChi(khachDto.getDiaChi());
        khach.setEmail(khachDto.getEmail());
        khachRepository.save(khach);
        return ResponseEntity.ok(khach);
    }

    public ResponseEntity<List<Khach>> listAllKhach() {
        List<Khach> listKhach = khachRepository.findAll();
        if(listKhach.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listKhach);
    }

    public ResponseEntity<Khach> updateKhach(Long id, KhachDto khachDto) {
        Khach khach = khachRepository.getOne(id);
        if(khach == null){
            return ResponseEntity.notFound().build();
        }
        khach.setTenKhach(khachDto.getTenKhach());
        Khach updateKhach = khachRepository.save(khach);
        return ResponseEntity.ok(updateKhach);
    }

    public ResponseEntity<Khach> deleteKhach(Long id) {
        Khach khach = khachRepository.getOne(id);
        if(khach == null){
            return ResponseEntity.notFound().build();
        }
        khachRepository.delete(khach);
        return ResponseEntity.ok().build();
    }
}
