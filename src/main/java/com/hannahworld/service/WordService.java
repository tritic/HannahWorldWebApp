package com.hannahworld.service;

import java.util.List;

import com.hannahworld.exception.WordNotFound;
import com.hannahworld.model.Word;

public interface WordService {
	
	public Word create(Word word);
	public Word delete(int id) throws WordNotFound;
	public List<Word> findAll();
	public Word update(Word word) throws WordNotFound;
	public Word findById(int id);

}
