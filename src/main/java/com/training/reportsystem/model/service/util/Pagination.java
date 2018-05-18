package com.training.reportsystem.model.service.util;

import java.util.LinkedList;
import java.util.List;

public class Pagination {

    private LinkedList<Page> pages = new LinkedList<>();
    private static final int ITEMS_ON_PAGE = 5;
    private int page;
    private int totalCount;

    public Pagination(int page) {
        this.page = page;
    }

    public void fillPages() {
        for (int index = 1; index <= calculateMaxPage(totalCount); index++) {
            addPage(index);
        }
    }

    public boolean isPageEmpty(List list) {
        return list.isEmpty() && page != 1;
    }

    public int getLastPageNum() {
        return this.pages.getLast().getNumber();
    }

    public boolean pagesPresent() {
        return pages.size() > 1;
    }

    private void addPage(int index) {
        if (pages.size() < 5) {
            pages.add(createPage(index));
        } else {
            shiftPages(index);
        }
    }

    private void shiftPages(int index) {
        if (page > pages.getLast().getNumber() / 2 + 1) {
            pages.removeFirst();
            pages.add(createPage(index));
        }
    }

    private Page createPage(int index) {
        if (index == this.page) {
            return new Page(index, true);
        } else {
            return new Page(index);
        }
    }

    private int calculateMaxPage(int totalCount) {
        int limit;
        if (totalCount % ITEMS_ON_PAGE == 0) {
            limit = totalCount / ITEMS_ON_PAGE;
        } else {
            limit = (totalCount / ITEMS_ON_PAGE) + 1;
        }
        return limit;
    }

    public LinkedList<Page> getPages() {
        return pages;
    }

    public int getItemsOnPage() {
        return ITEMS_ON_PAGE;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
