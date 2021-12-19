package com.hellospring.demo.presenter;

import com.hellospring.demo.model.Barang;
import com.hellospring.demo.model.DetailPenjualan;
import com.hellospring.demo.service.DetailPenjualanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DetailPenjualanPresenter {
    @Autowired
    private DetailPenjualanServiceImpl detailPenjualanService;

    @GetMapping("detail/jumlah")
    public List<DetailPenjualan> getJumlahBarang(){
        return detailPenjualanService.JumlahBarangdetailPenjualan();
    }

    @GetMapping("detail/total")
    public List<DetailPenjualan> getTotalHarga(){
        return detailPenjualanService.TotalHargadetailPenjualan();
    }
}
