package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Bond;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BondRepository extends JpaRepository <Bond, Long>
{
    @Query(nativeQuery = true, value = "select * from bonds where name = :isin")
    Bond findByIsin(int isin);

}
