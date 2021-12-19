package com.hellospring.demo.service;

import com.hellospring.demo.exception.ResourceNotFoundException;
import com.hellospring.demo.model.Barang;
import com.hellospring.demo.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BarangServiceImpl implements BarangService {

    @Autowired
    private BarangRepository barangRepository;

    @Override
    public List<Barang> allBarang() {
        return barangRepository.findAll();
    }

    @Override
    public Optional<Barang> detailBarang(Long id) {
        return barangRepository.findById(id);
    }

    @Override
    public ResponseEntity<Object> postBarang(Barang barang) {
        return new ResponseEntity<>(barangRepository.save(barang), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> putBarang(@PathVariable Long id, @RequestBody Barang barang) {
        Barang barang1 = barangRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Barang Tidak ditemukan"));

        barang1.setNama_barang(barang1.getNama_barang());
        barang1.setHarga_barang(barang1.getHarga_barang());
        barang1.setStok_barang(barang1.getStok_barang());
        barangRepository.save(barang);

        return new ResponseEntity<>(barang1,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteBarang(Long id) {
        Barang barang = barangRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Barang Tidak ditemukan"));
        barangRepository.delete(barang);
        return new ResponseEntity<>(barang,HttpStatus.OK);
    }
}
