package com.example.sales_management.entyti;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hang")
public class Hang {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ten_hang")
    private String tenHang;

    @Column(name = "don_vi")
    private String donVi;

    @Column(name = "don_gia")
    private long donGia;

    @OneToMany
    @JoinColumn(name = "hang_id")
    private Set<HangBan> hangBan;

    public Hang() {
    }

    public Hang(long id, String tenHang, String donVi, long donGia, Set<HangBan> hangBan) {
        this.id = id;
        this.tenHang = tenHang;
        this.donVi = donVi;
        this.donGia = donGia;
        this.hangBan = hangBan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }
    @JsonBackReference
    public Set<HangBan> getHangBan() {
        return hangBan;
    }

    public void setHangBan(Set<HangBan> hangBan) {
        this.hangBan = hangBan;
    }
}
