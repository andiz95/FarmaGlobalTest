package com.hellospring.demo.service;

import com.hellospring.demo.exception.ResourceNotFoundException;
import com.hellospring.demo.mapper.PostPenjualan;
import com.hellospring.demo.mapper.PutPenjualan;
import com.hellospring.demo.model.Barang;
import com.hellospring.demo.model.Penjualan;
import com.hellospring.demo.model.dto.CreateDetailPenjualan;
import com.hellospring.demo.model.dto.CreatePenjualan;
import com.hellospring.demo.model.dto.EditPenjualan;
import com.hellospring.demo.repository.BarangRepository;
import com.hellospring.demo.repository.PenjualanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PenjualanServiceImpl implements PenjualanService{
    @Autowired
    private PenjualanServiceImpl penjualanService;

    @Autowired
    private PenjualanRepository penjualanRepository;

    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private PostPenjualan postPenjualan;

    @Autowired
    private PutPenjualan putPenjualan;

    @Override
    public Page<Penjualan> getPagePenjualan(Date tanggal_penjualan, Integer page, Integer size) {
        Pageable paging = PageRequest.of(page,size);

        return penjualanRepository.findByDate(tanggal_penjualan,paging);
    }

    @Override
    public ResponseEntity<Object> detailPenjualan(Long id)
    {
        Penjualan penjualan = penjualanRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ID penjualan tidak ditemukan"));
        return new ResponseEntity<>(penjualan, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> postPenjualan( @RequestBody Penjualan penjualans)
    {
//        Penjualan penjualan1 = postPenjualan.penjualanPostToEntity(createPenjualan,createDetailPenjualan);
        List<Penjualan> penjualan = penjualanRepository.InsertData(penjualans);

        return new ResponseEntity<>(penjualan,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> putPenjualan(@PathVariable Long id, EditPenjualan editPenjualan)
    {
        Penjualan penjualan1 = putPenjualan.penjualanPutToEntity(id,editPenjualan);

        return new ResponseEntity<>(penjualan1,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deletePenjualan(Long id)
    {
        Penjualan penjualan = penjualanRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Penjualan Tidak ditemukan"));
        penjualanRepository.delete(penjualan);
        return new ResponseEntity<>(penjualan,HttpStatus.OK);
    }
}
