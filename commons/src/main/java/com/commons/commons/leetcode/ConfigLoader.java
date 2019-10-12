package com.commons.commons.leetcode;

import java.util.Properties;

public interface ConfigLoader {
	/**
	 * Load Config
	 * @param name fileName or Database
	 */
	public Properties load() throws Exception;
	
	public void save(Properties properties) throws Exception;
}
