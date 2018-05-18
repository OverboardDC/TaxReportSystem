package com.training.reportsystem.model.service;

import com.training.reportsystem.model.service.util.Pagination;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PaginationTest {

    private Pagination pagination;

    @Test
    public void fillPagesTest(){
        pagination = new Pagination(1);
        pagination.setTotalCount(11);
        pagination.fillPages();
        assertEquals(3, pagination.getPages().getLast().getNumber());
    }

    @Test
    public void pageShiftingTest(){
        pagination = new Pagination(4);
        pagination.setTotalCount(27);
        pagination.fillPages();
        assertEquals(6, pagination.getLastPageNum());
        assertEquals(2, pagination.getPages().getFirst().getNumber());
    }
}
