package com.hannahworld.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hannahworld.exception.WordNotFound;
import com.hannahworld.model.Word;
import com.hannahworld.repository.WordRepository;

@Service
public class WordServiceImpl implements WordService {
	
	@Resource
	private WordRepository wordRepository;

	@Override
	@Transactional
	public Word create(Word word) {
		Word createdWord = word;
		return wordRepository.save(createdWord);
	}
	
	@Override
	@Transactional
	public Word findById(int id) {
		return wordRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=WordNotFound.class)
	public Word delete(int id) throws WordNotFound {
		Word deletedWord = wordRepository.findOne(id);
		
		if (deletedWord == null)
			throw new WordNotFound();
		
		wordRepository.delete(deletedWord);
		return deletedWord;
	}

	@Override
	@Transactional
	public List<Word> findAll() {
		return wordRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=WordNotFound.class)
	public Word update(Word word) throws WordNotFound {
		Word updatedWord = wordRepository.findOne(word.getId());
		
		if (updatedWord == null)
			throw new WordNotFound();
		
		updatedWord.setAword(word.getAword());
		updatedWord.setWeekNumber(word.getWeekNumber());
		return updatedWord;
	}

}
