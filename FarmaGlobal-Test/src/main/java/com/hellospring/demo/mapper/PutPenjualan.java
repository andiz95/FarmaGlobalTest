package com.hellospring.demo.mapper;

import com.hellospring.demo.exception.ResourceNotFoundException;
import com.hellospring.demo.model.Barang;
import com.hellospring.demo.model.Penjualan;
import com.hellospring.demo.model.dto.CreatePenjualan;
import com.hellospring.demo.model.dto.EditPenjualan;
import com.hellospring.demo.repository.BarangRepository;
import com.hellospring.demo.repository.PenjualanRepository;
import com.hellospring.demo.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class PutPenjualan {
    @Autowired
    private PenjualanRepository penjualanRepository;

    @Autowired
    private ModelMapperUtil modelMapperUtil;

    @Autowired
    private BarangRepository barangRepository;

    public Penjualan penjualanPutToEntity(@PathVariable Long id,EditPenjualan editPenjualan) {
        Penjualan penjualan1 = penjualanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID Penjualan tidak ditemukan"));

        Barang barang = barangRepository.findById(editPenjualan.getBarangID())
                .orElseThrow(() -> new ResourceNotFoundException("Barang tidak ditemukan"));

        Penjualan penjualan = modelMapperUtil.modelMapperUtil().map(editPenjualan, Penjualan.class);
        penjualan.setBarang(barang);
        penjualan.setBanyak_barang(editPenjualan.getBanyak_barang());
        penjualan.setTanggal_penjualan(editPenjualan.getTanggal_penjualan());
        penjualan.setNama_pembeli(editPenjualan.getNama_pembeli());
        penjualan.setNo_hp_pembeli(editPenjualan.getNo_hp_pembeli());
        penjualan.setJumlah_uang_pembeli(editPenjualan.getJumlah_uang_pembeli());
        penjualan.setHarga_barang(editPenjualan.getHarga_barang());

        penjualan1.setBarang(penjualan.getBarang());
        penjualan1.setBanyak_barang(penjualan.getBanyak_barang());
        penjualan1.setTanggal_penjualan(penjualan.getTanggal_penjualan());
        penjualan1.setNama_pembeli(penjualan.getNama_pembeli());
        penjualan1.setNo_hp_pembeli(penjualan.getNo_hp_pembeli());
        penjualan1.setJumlah_uang_pembeli(penjualan.getJumlah_uang_pembeli());
        penjualan1.setHarga_barang(penjualan.getHarga_barang());

        return penjualanRepository.save(penjualan1);
    }
}
