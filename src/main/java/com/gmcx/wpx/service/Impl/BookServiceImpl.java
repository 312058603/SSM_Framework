package com.gmcx.wpx.service.Impl;

import com.gmcx.wpx.dao.BookDao;
import com.gmcx.wpx.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wpx on 2017/8/7.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    public int insertBook(Map<String,Object> map) {
        int count=bookDao.insertBook(map);
        return count;
    }
}
