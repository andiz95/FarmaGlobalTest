package com.hellospring.demo.service;

import com.hellospring.demo.model.Barang;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface BarangService {
    List<Barang> allBarang();
    Optional<Barang> detailBarang(Long id);
    ResponseEntity<Object> postBarang(@RequestBody Barang barang);
    ResponseEntity<Object> putBarang(@PathVariable Long id, @RequestBody Barang barang);
    ResponseEntity<Object> deleteBarang(@PathVariable Long id);
}
