package com.hannahworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hannahworld.exception.WordNotFound;
import com.hannahworld.model.Word;
import com.hannahworld.service.WordService;

@Controller
@RequestMapping(value="/word")
public class WordController {
	
	@Autowired
	private WordService wordService;

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newWordPage() {
		ModelAndView mav = new ModelAndView("word-new", "word", new Word());
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewWord(@ModelAttribute Word word, 
			final RedirectAttributes redirectAttributes) {
		
		ModelAndView mav = new ModelAndView();
		String message = "New word "+word.getAword()+" was successfully created.";
		
		wordService.create(word);
		mav.setViewName("redirect:/index.html");
				
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView wordListPage() {
		ModelAndView mav = new ModelAndView("word-list");
		List<Word> wordList = wordService.findAll();
		mav.addObject("wordList", wordList);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editWordPage(@PathVariable Integer id) {
		ModelAndView mav;
		Word word = wordService.findById(id);
		if(word==null){
			new WordNotFound(""+id);
			mav = new ModelAndView("");			
	        mav.setViewName("error/404");    
		}
		else {
		mav = new ModelAndView("word-edit");
		mav.addObject("word", word);
		}
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editWord(@ModelAttribute Word word,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws WordNotFound {

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Word was successfully updated.";

		wordService.update(word);

		redirectAttributes.addFlashAttribute("message", message);	
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteWord(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws WordNotFound {
		
		ModelAndView mav = new ModelAndView("redirect:/index.html");		
		
		Word word = wordService.delete(id);
		String message = "The word "+word.getAword()+" was successfully deleted.";
		
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
}
