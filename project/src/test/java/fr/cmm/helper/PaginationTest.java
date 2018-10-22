package fr.cmm.helper;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaginationTest {



    @Test
    public void isMultiplePageSize() {
        Pagination pagination = new Pagination();
        pagination.setCount(60);
        pagination.setPageSize(20);
        assertEquals(3,pagination.getPageCount());
    }

    @Test
    public void isNotMultiplePageSize() {
        Pagination pagination = new Pagination();
        pagination.setCount(55);
        pagination.setPageSize(25);
        assertEquals(3, pagination.getPageCount());
    }

    @Test
    public void IsNull() {
        Pagination pagination = new Pagination();
        pagination.setCount(0);
        pagination.setPageSize(20);
        assertEquals(pagination.getPageCount(), 0);
    }

    @Test
    public void PageSizeOversized() {
        Pagination pagination = new Pagination();
        pagination.setCount(20);
        pagination.setPageSize(50);
        assertEquals(1, pagination.getPageCount());
    }


    }