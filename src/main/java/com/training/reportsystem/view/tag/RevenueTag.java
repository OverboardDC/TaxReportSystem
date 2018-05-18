package com.training.reportsystem.view.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.DecimalFormat;

public class RevenueTag extends TagSupport {

    private Long revenue;

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    @Override
    public int doStartTag() throws JspException {
        long dollars = revenue / 100;
        long cents = revenue % 100;
        JspWriter out = pageContext.getOut();
        try {
            if(cents > 0){
                out.write(dollars + "." + DecimalFormat.getInstance().format(cents));
            } else {
                out.write(String.valueOf(dollars));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
