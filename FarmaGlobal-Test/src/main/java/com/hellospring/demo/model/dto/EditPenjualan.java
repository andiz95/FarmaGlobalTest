package com.hellospring.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class EditPenjualan {
    private Long id_penjualan;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+7")
    private Date tanggal_penjualan;
    private String nama_pembeli;
    private String no_hp_pembeli;
    private int jumlah_uang_pembeli;
    private int banyak_barang;
    private int harga_barang;
    private Long barangID;
}
