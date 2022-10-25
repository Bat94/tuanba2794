package com.example.sales_management.entyti;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "hangban")
public class HangBan {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "hoa_don_id")
    private HoaDon hoaDonId;

    @Column(name = "so_luong")
    private int soLuong;

    @ManyToOne
    @JoinColumn(name = "hang_id")
    private Hang hangId;

    public HangBan() {
    }

    public HangBan(long id, HoaDon hoaDonId, int soLuong, Hang hangId) {
        this.id = id;
        this.hoaDonId = hoaDonId;
        this.soLuong = soLuong;
        this.hangId = hangId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @JsonManagedReference
    public HoaDon getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(HoaDon hoaDonId) {
        this.hoaDonId = hoaDonId;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    @JsonManagedReference
    public Hang getHangId() {
        return hangId;
    }

    public void setHangId(Hang hangId) {
        this.hangId = hangId;
    }
}
