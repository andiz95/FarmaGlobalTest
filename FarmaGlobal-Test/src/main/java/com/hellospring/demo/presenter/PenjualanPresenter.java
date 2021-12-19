package com.hellospring.demo.presenter;

import com.hellospring.demo.model.Barang;
import com.hellospring.demo.model.Penjualan;
import com.hellospring.demo.model.dto.CreatePenjualan;
import com.hellospring.demo.model.dto.EditPenjualan;
import com.hellospring.demo.service.PenjualanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PenjualanPresenter {
    @Autowired
    private PenjualanServiceImpl penjualanService;

    @GetMapping("penjualan")
    public ResponseEntity<Object> getAllPenjualan(@RequestParam(defaultValue = "0") Integer page,
                                                  @RequestParam(defaultValue = "5") Integer size,
                                                  @RequestParam(required = false) Date tanggal_penjualan)
    {
        return new ResponseEntity<>(penjualanService.getPagePenjualan(tanggal_penjualan,page, size), HttpStatus.OK) ;
    }

    @GetMapping("penjualan/{id}")
    public ResponseEntity<Object> getPenjualanByID(@PathVariable Long id){
        return penjualanService.detailPenjualan(id);
    }

    @PostMapping("penjualan")
    public ResponseEntity<Object> postPenjualan(@RequestBody CreatePenjualan createPenjualan){
        return penjualanService.postPenjualan(createPenjualan);
    }

    @PutMapping("penjualan/{id}")
    public ResponseEntity<Object> putPenjualan(@PathVariable Long id,@RequestBody EditPenjualan editPenjualan){
        return penjualanService.putPenjualan(id,editPenjualan);
    }

    @DeleteMapping("penjualan/{id}")
    public ResponseEntity<Object> deletePenjualan(@PathVariable Long id){
        return penjualanService.deletePenjualan(id);
    }
}
