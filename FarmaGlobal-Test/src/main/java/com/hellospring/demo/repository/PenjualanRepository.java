package com.hellospring.demo.repository;

import com.hellospring.demo.model.Penjualan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PenjualanRepository extends JpaRepository<Penjualan,Long> {
    @Query(value = "SELECT * FROM penjualan WHERE tanggal_penjualan BETWEEN '10/10/2020' and '11/11/2020'",nativeQuery = true)
    Page<Penjualan>findByDate(Date tanggal_penjualan, Pageable paging);

}
