package com.hellospring.demo.service;

import com.hellospring.demo.model.DetailPenjualan;
import com.hellospring.demo.repository.DetailPenjualanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailPenjualanServiceImpl implements DetailPenjualanService {

    @Autowired
    private DetailPenjualanRepository detailPenjualanRepository;

    @Override
    public List<DetailPenjualan> JumlahBarangdetailPenjualan() {
        return detailPenjualanRepository.findJumlahBarang();
    }

    @Override
    public List<DetailPenjualan> TotalHargadetailPenjualan() {
        return detailPenjualanRepository.findTotalPenjualan();
    }
}
