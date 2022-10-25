package com.example.sales_management.service;

import com.example.sales_management.entyti.Hang;
import com.example.sales_management.entyti.HangBan;
import com.example.sales_management.entyti.HoaDon;
import com.example.sales_management.model.HangBanDto;
import com.example.sales_management.model.HangDto;
import com.example.sales_management.repository.HangBanRepository;
import com.example.sales_management.repository.HangRepository;
import com.example.sales_management.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HangBanService {
    @Autowired
    private HangBanRepository hangBanRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private HangRepository hangRepository;
    public ResponseEntity<HangBan> postHangBan(HangBanDto hangBanDto) {
        Optional<Hang> hang = hangRepository.findById(hangBanDto.getHangId());
        Optional<HoaDon> hoaDon = hoaDonRepository.findById(hangBanDto.getHoaDonId());
        if(hang.isEmpty()||hoaDon.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        HangBan hangBan = new HangBan();
        hangBan.setHangId(hang.get());
        hangBan.setHoaDonId(hoaDon.get());
        hangBan.setSoLuong(hangBanDto.getSoLuong());
        hangBanRepository.save(hangBan);
        return ResponseEntity.ok(hangBan);
    }

    public ResponseEntity<List<HangBan>> listAllHangBan() {
        List<HangBan> listHangBan = hangBanRepository.findAll();
        if(listHangBan.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listHangBan);
    }

    public ResponseEntity<HangBan> updateHangBan(Long id, HangBanDto hangbanDto) {
        HangBan hangBan = hangBanRepository.getOne(id);
        if(hangBan == null){
            return ResponseEntity.notFound().build();
        }
        hangBan.setSoLuong(hangbanDto.getSoLuong());
        HangBan updateHangBan = hangBanRepository.save(hangBan);
        return ResponseEntity.ok(updateHangBan);
    }

    public ResponseEntity<HangBan> deleteHangBan(Long id) {
        HangBan hangBan = hangBanRepository.getOne(id);
        if(hangBan== null){
            return ResponseEntity.notFound().build();
        }
        hangBanRepository.delete(hangBan);
        return ResponseEntity.ok().build();
    }
}
