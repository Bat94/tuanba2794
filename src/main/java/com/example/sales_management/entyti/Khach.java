package com.example.sales_management.entyti;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "khach")
public class Khach {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ten_khach")
    private String tenKhach;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column
    private String email;

    @Column
    private String picture;

    @OneToMany
    @JoinColumn(name = "khach_id")
    private Set<HoaDon> hoaDon;

    public Khach() {
    }

    public Khach(long id, String tenKhach, String diaChi, String email, String picture, Set<HoaDon> hoaDon) {
        this.id = id;
        this.tenKhach = tenKhach;
        this.diaChi = diaChi;
        this.email = email;
        this.picture = picture;
        this.hoaDon = hoaDon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    @JsonBackReference
    public Set<HoaDon> getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(Set<HoaDon> hoaDon) {
        this.hoaDon = hoaDon;
    }
}
