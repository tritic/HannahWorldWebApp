package com.hannahworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hannahworld.model.Word;

public interface WordRepository extends JpaRepository<Word, Integer> {

}
