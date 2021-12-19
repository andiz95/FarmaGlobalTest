package com.hellospring.demo.presenter;

import com.hellospring.demo.model.Barang;
import com.hellospring.demo.service.BarangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class BarangPresenter {
    @Autowired
    private BarangServiceImpl barangService;

    @GetMapping("barang")
    public List<Barang> getAllBarang(){
        return barangService.allBarang();
    }

    @GetMapping("barang/{id}")
    public Optional<Barang> getAllbarang(@PathVariable Long id){
        return barangService.detailBarang(id);
    }

    @PostMapping("barang")
    public ResponseEntity<Object> postBarang(@RequestBody Barang barang){
        return barangService.postBarang(barang);
    }

    @PutMapping("barang/{id}")
    public ResponseEntity<Object> putBarang(@PathVariable Long id, @RequestBody Barang barang){
        return barangService.putBarang(id,barang);
    }

    @DeleteMapping("barang/{id}")
    public ResponseEntity<Object> deleteBarang(@PathVariable Long id){
        return barangService.deleteBarang(id);
    }
}
