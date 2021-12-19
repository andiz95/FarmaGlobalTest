package com.hellospring.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "detail_penjualan")
public class DetailPenjualan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detailPenjualan")
    private Long id_detailPenjualan;
    @Column(name = "jumlah_barang")
    private int jumlah_barang;
    @Column(name = "total_penjualan")
    private int total_penjualan;

//    @JsonIgnore
//    @OneToOne(mappedBy = "detailPenjualan")
//    private Penjualan penjualan;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "penjualan_id",referencedColumnName = "id_penjualan")
    private Penjualan penjualan;
}
