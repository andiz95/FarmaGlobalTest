package com.hellospring.demo.service;

import com.hellospring.demo.model.Penjualan;
import com.hellospring.demo.model.dto.CreatePenjualan;
import com.hellospring.demo.model.dto.EditPenjualan;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

public interface PenjualanService {
    Page<Penjualan> getPagePenjualan(Date tanggal_penjualan, Integer page, Integer size);
    ResponseEntity<Object> detailPenjualan(Long id);
    ResponseEntity<Object> postPenjualan(@RequestBody  CreatePenjualan createPenjualan);
    ResponseEntity<Object> putPenjualan(@PathVariable Long id, EditPenjualan editPenjualan);
    ResponseEntity<Object> deletePenjualan(@PathVariable Long id);
}
