package com.hellospring.demo.repository;

import com.hellospring.demo.model.DetailPenjualan;
import com.hellospring.demo.model.Penjualan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DetailPenjualanRepository extends JpaRepository<DetailPenjualan,Long> {
    @Query(value = "SELECT SUM(p.banyak_barang) as jumlah_barang from penjualan p",nativeQuery = true)
    List<DetailPenjualan> findJumlahBarang();
    @Query(value = "SELECT SUM(p.harga_barang) as total_penjualan from penjualan p",nativeQuery = true)
    List<DetailPenjualan> findTotalPenjualan();
}
