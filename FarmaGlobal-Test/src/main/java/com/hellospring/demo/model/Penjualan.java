package com.hellospring.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "penjualan")
public class Penjualan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_penjualan")
    private Long id_penjualan;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
    @Column(name = "tanggal_penjualan")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggal_penjualan;
    @Column(name = "nama_pembeli")
    private String nama_pembeli;
    @Column(name = "no_hp_pembeli")
    private String no_hp_pembeli;
    @Column(name = "jumlah_uang_pembeli")
    private int jumlah_uang_pembeli;
    @Column(name = "banyak_barang")
    private int banyak_barang;
    @Column(name = "harga_barang")
    private int harga_barang;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "barang_id",referencedColumnName = "id_barang")
//    private Barang barang;

//    @OneToMany(mappedBy = "penjualan")
//    private List<Barang> barang;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detailPenjualan_id",referencedColumnName = "id_detailPenjualan")
    private DetailPenjualan detailPenjualan;

//    @JsonIgnore
//    @OneToOne(mappedBy = "penjualan")
//    private DetailPenjualan detailPenjualan;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "detailPenjualan_id",referencedColumnName = "id_detailPenjualan")
//    private DetailPenjualan detailPenjualan;
}
