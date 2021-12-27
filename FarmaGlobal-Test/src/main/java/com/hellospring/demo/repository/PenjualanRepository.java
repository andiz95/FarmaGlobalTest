package com.hellospring.demo.repository;

import com.hellospring.demo.model.DetailPenjualan;
import com.hellospring.demo.model.Penjualan;
import com.hellospring.demo.model.dto.CreateDetailPenjualan;
import com.hellospring.demo.model.dto.CreatePenjualan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Repository
public interface PenjualanRepository extends JpaRepository<Penjualan,Long> {
    @Query(value = "SELECT * FROM penjualan WHERE tanggal_penjualan BETWEEN '9/9/2020' and '12/12/2020'",nativeQuery = true)
    Page<Penjualan>findByDate(Date tanggal_penjualan, Pageable paging);

    @Query(value = "INSERT INTO penjualan (tanggal_penjualan,nama_pembeli,no_hp_pembeli,jumlah_uang_pembeli,\n" +
            "banyak_barang,harga_barang,detail_penjualan_id)" +
            "\tVALUES (?,?,?,?,?,?,?);" +
            "INSERT INTO detail_penjualan(jumlah_barang,total_penjualan,barang_id,penjualan_id) \n" +
            "\tVALUES (?,?,?,?);\n" +
            "COMMIT",nativeQuery = true)
    List<Penjualan>InsertData(@RequestBody Penjualan penjualans);
}
