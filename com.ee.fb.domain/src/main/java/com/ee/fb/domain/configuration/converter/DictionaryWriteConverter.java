package com.ee.fb.domain.configuration.converter;


import org.springframework.core.convert.converter.Converter;

import com.ee.core.dictionary.Dictionary;

public class DictionaryWriteConverter implements Converter<Dictionary<String>, String> {

	@Override
	public String convert(Dictionary<String> source) {
		if (source!=null)
			return source.getId();	
		return null;
	}


}
