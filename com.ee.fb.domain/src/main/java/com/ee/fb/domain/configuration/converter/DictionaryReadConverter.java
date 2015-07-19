package com.ee.fb.domain.configuration.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ee.core.dictionary.Dictionary;
import com.ee.core.dictionary.DictionaryRepository;

public class DictionaryReadConverter implements Converter<String, Dictionary<String>>{

	@Autowired
	private DictionaryRepository dictionaryRepository;
	
	@Override
	public Dictionary<String> convert(String source) {
		assert dictionaryRepository!=null;
		//TODO
		return dictionaryRepository.getDictionaryRecord(source, null);
	}
	
	

}
