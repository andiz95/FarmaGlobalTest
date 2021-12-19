package com.hellospring.demo.service;

import com.hellospring.demo.model.DetailPenjualan;

import java.util.List;

public interface DetailPenjualanService {
    List<DetailPenjualan> JumlahBarangdetailPenjualan();
    List<DetailPenjualan> TotalHargadetailPenjualan();
}
