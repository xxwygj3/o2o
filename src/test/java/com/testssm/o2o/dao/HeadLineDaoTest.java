package com.testssm.o2o.dao;

import com.testssm.o2o.BaseTest;
import com.testssm.o2o.entity.HeadLine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HeadLineDaoTest extends BaseTest {
    @Autowired
    private HeadLineDao headLineDao;

    @Test
    public void testQueryHeadLine() throws Exception{
        List<HeadLine> headLineList =headLineDao.queryHeadLine(new HeadLine());
        assertEquals(4,headLineList.size());
    }
}
