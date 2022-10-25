package com.example.sales_management.entyti;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "hoadon")
public class HoaDon {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ngay_ban")
    private Date ngayBan;

    @ManyToOne
    @JoinColumn(name = "khach_id")
    private Khach khachId;

    @OneToMany
    @JoinColumn(name = "hoadon_id")
    private Set<HangBan> hangBan;

    public HoaDon() {
    }

    public HoaDon(long id, Date ngayBan, Khach khachId, Set<HangBan> hangBan) {
        this.id = id;
        this.ngayBan = ngayBan;
        this.khachId = khachId;
        this.hangBan = hangBan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }
    @JsonManagedReference
    public Khach getKhachId() {
        return khachId;
    }

    public void setKhachId(Khach khachId) {
        this.khachId = khachId;
    }
    @JsonBackReference
    public Set<HangBan> getHangBan() {
        return hangBan;
    }

    public void setHangBan(Set<HangBan> hangBan) {
        this.hangBan = hangBan;
    }
}
