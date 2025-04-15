package com.val.gerencial.repository;

import com.val.gerencial.model.Gerencial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerencialRepository extends JpaRepository<Gerencial, Long> {
}
