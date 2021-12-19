package com.hellospring.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "barang")
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barang")
    private Long id_barang;
    @Column(name = "nama_barang")
    private String nama_barang;
    @Column(name = "harga_barang")
    private int harga_barang;
    @Column(name = "stok_barang")
    private int stok_barang;

//    @JsonBackReference
//    @OneToMany(mappedBy = "penjualan")
//    private List<Penjualan> penjualans;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "penjualan_id",referencedColumnName = "id_penjualan")
//    private Penjualan penjualan;

}
