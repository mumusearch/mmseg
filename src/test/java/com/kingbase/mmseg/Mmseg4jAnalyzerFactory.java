package com.kingbase.mmseg;

import com.kingbase.mmseg.analysis.ComplexAnalyzer;
import com.kingbase.mmseg.analysis.MMSegAnalyzer;
import com.kingbase.mmseg.analysis.SimpleAnalyzer;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class Mmseg4jAnalyzerFactory extends TestCase {
    private static final String path = getMmsegPath();//mmseg4j 配置路径

    private static final Logger log = Logger.getLogger(Mmseg4jAnalyzerFactory.class);

    public static SimpleAnalyzer simpleAnalyzer() {
        return new SimpleAnalyzer(path);
    }

    public static ComplexAnalyzer complexAnalyzer() {
        return new ComplexAnalyzer(path);
    }

    /**
     * 获取配置路径
     *
     * @return
     */
    private static String getMmsegPath() {
        return Mmseg4jAnalyzerFactory.class.getResource("/mmseg").getFile();
    }

    public void testMmseg() throws IOException {
        MMSegAnalyzer analyzer = Mmseg4jAnalyzerFactory.complexAnalyzer();

        TokenStream tokenStream = analyzer.tokenStream("", "我爱你");
        CharTermAttribute termAttr = tokenStream.addAttribute(CharTermAttribute.class);

        tokenStream.reset();

        while (tokenStream.incrementToken()) {
            log.info(termAttr.toString());
        }

        analyzer.close();
    }
}
