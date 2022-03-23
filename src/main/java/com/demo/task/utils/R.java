package com.demo.task.utils;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @功能描述: <pre></pre>
 * @Classname R
 * @Author: wanjiansheng@tansun.com.cn
 * @Date: 2022/3/10 14:45
 * @Version: 1.0
 */
public class R extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("isSuccess", true);
        put("msg", "请求成功");
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("isSuccess", false);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Object object) {
        R r = new R();
        r.put("data",object);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
