package com.vasiliy.project.repository;

import com.vasiliy.project.entity.records.WrittenOffRecord;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WrittenOffRecordRepository extends JpaRepository<WrittenOffRecord, Long> {

  @Query("SELECT wor FROM WrittenOffRecord wor JOIN wor.storageProduct sp WHERE sp.product.id = :productId AND wor.writtenOffAt BETWEEN :startDate AND :endDate ORDER BY wor.writtenOffAt ASC")
  List<WrittenOffRecord> findAllByProductIdAndBetweenDates(
      @Param("productId") Long productId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate);
}
