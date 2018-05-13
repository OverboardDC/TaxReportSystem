package com.training.reportsystem.util;

import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class PaginationUtil {

    public static int getPageParameter(HttpServletRequest request){
        int page = 1;
        Optional<String> param = Optional.ofNullable(request.getParameter(Parameters.PAGE));
        if(param.isPresent()){
            page = Integer.parseInt(param.get());
        }
        return page;
    }

    public static void setAttribute(Pagination pagination, HttpServletRequest request){
        pagination.fillPages();
        if(pagination.pagesPresent()) {
            request.setAttribute(Attributes.PAGES, pagination.getPages());
        }
    }
}
