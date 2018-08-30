package com.gmcx.wpx.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by wpx on 2017/8/7.
 */
@Repository
public interface BookDao {

    public int insertBook(Map<String,Object> map);

}
