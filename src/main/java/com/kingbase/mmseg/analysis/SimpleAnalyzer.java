package com.kingbase.mmseg.analysis;

import java.io.File;

import com.kingbase.mmseg.core.Dictionary;
import com.kingbase.mmseg.core.Seg;
import com.kingbase.mmseg.core.SimpleSeg;

/**
 * mmseg 的 simple anlayzer.
 * 
 * @author chenlb 2009-3-16 下午10:08:13
 */
public class SimpleAnalyzer extends MMSegAnalyzer {
	
	public SimpleAnalyzer() {
		super();
	}
	
	public SimpleAnalyzer(String path) {
		super(path);
	}
	
	public SimpleAnalyzer(Dictionary dic) {
		super(dic);
	}

	public SimpleAnalyzer(File path) {
		super(path);
	}

	protected Seg newSeg() {
		return new SimpleSeg(dic);
	}
}
