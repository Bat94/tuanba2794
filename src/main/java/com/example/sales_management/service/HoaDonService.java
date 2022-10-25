package com.example.sales_management.service;

import com.example.sales_management.entyti.HoaDon;
import com.example.sales_management.entyti.Khach;
import com.example.sales_management.model.HoaDonDto;
import com.example.sales_management.repository.HoaDonRepository;
import com.example.sales_management.repository.KhachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private KhachRepository khachRepository;

    public ResponseEntity<HoaDon> postHoaDon(HoaDonDto hoaDonDto) {
        Optional<Khach> khach = khachRepository.findById(hoaDonDto.getKhachId());
        if(khach.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        HoaDon hoaDon = new HoaDon();
        hoaDon.setKhachId(khach.get());
        hoaDon.setNgayBan(hoaDonDto.getNgayBan());
        hoaDonRepository.save(hoaDon);
        return ResponseEntity.ok(hoaDon);
    }

    public ResponseEntity<List<HoaDon>> listAllHoaDon() {
        List<HoaDon> listHoaDon = hoaDonRepository.findAll();
        if(listHoaDon.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listHoaDon);
    }

    public ResponseEntity<HoaDon> updateHoaDon(Long id, HoaDonDto hoaDonDto) {
        HoaDon hoaDon = hoaDonRepository.getOne(id);
        if(hoaDon == null){
            return ResponseEntity.notFound().build();
        }
        hoaDon.setNgayBan(hoaDonDto.getNgayBan());
        HoaDon updateHoaDon = hoaDonRepository.save(hoaDon);
        return ResponseEntity.ok(updateHoaDon);
    }

    public ResponseEntity<HoaDon> deleteHoaDon(Long id) {
        HoaDon hoaDon = hoaDonRepository.getOne(id);
        if(hoaDon == null){
            return ResponseEntity.notFound().build();
        }
        hoaDonRepository.delete(hoaDon);
        return ResponseEntity.ok().build();
    }
}
