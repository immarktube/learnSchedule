package com.learn.demo.abstractProxy;

import java.util.List;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2021/9/8 11:37 上午
 **/
public abstract class AbstractTranslator {

    public abstract List<String> getRules(String var1);

    public abstract Object parse(String var1);

    public abstract Object translate(Object var1);
}
