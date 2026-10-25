package com.proj.finHelper.repository;

import com.proj.finHelper.entity.Lender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LenderRepository extends JpaRepository<Lender, Integer> {
    boolean existByLenderCode(String code);
    boolean existByGstNo(String gstNo);
    boolean existByRbiLicenceNo(String rbiLicenceNo);

}
