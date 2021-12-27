package com.hellospring.demo.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateDetailPenjualan {
    private Long id_detailPenjualan;
    private int jumlah_barang;
    private int total_penjualan;
    private Long barangID;
    private Long penjualanID;
}
