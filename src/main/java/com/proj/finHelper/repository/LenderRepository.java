package com.proj.finHelper.repository;

import com.proj.finHelper.entity.Lender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderRepository extends JpaRepository<Lender, Integer> {
    boolean existsByLenderCode(String code);
    boolean existsByGstNo(String gstNo);
    boolean existsByRbiLicenceNo(String rbiLicenceNo);

}
