package com.cts.sbwdd.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.sbwdd.entities.Consumer;

public interface ConsumerRepo extends JpaRepository<Consumer, Long>{
}