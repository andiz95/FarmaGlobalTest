package com.hellospring.demo.mapper;

import com.hellospring.demo.exception.ResourceNotFoundException;
import com.hellospring.demo.model.Barang;
import com.hellospring.demo.model.Penjualan;
import com.hellospring.demo.model.dto.CreatePenjualan;
import com.hellospring.demo.repository.BarangRepository;
import com.hellospring.demo.repository.PenjualanRepository;
import com.hellospring.demo.util.ModelMapperUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PostPenjualan {
    @Autowired
    private PenjualanRepository penjualanRepository;

    @Autowired
    private ModelMapperUtil modelMapperUtil;

    @Autowired
    private BarangRepository barangRepository;

    public Penjualan penjualanPostToEntity(CreatePenjualan createPenjualan) {
        Penjualan penjualan = modelMapperUtil.modelMapperUtil().map(createPenjualan, Penjualan.class);
        Barang barang = barangRepository.findById(createPenjualan.getBarangID())
                .orElseThrow(() -> new ResourceNotFoundException("Barang tidak ditemukan"));

        penjualan.setBarang(barang);
        penjualan.setBanyak_barang(createPenjualan.getBanyak_barang());
        penjualan.setTanggal_penjualan(createPenjualan.getTanggal_penjualan());
        penjualan.setNama_pembeli(createPenjualan.getNama_pembeli());
        penjualan.setNo_hp_pembeli(createPenjualan.getNo_hp_pembeli());
        penjualan.setJumlah_uang_pembeli(createPenjualan.getJumlah_uang_pembeli());
        penjualan.setHarga_barang(createPenjualan.getHarga_barang());

        return penjualanRepository.save(penjualan);
    }
}
