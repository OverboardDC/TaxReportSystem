package com.training.reportsystem.util.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.DecimalFormat;

public class TaxTag extends TagSupport {

    private Double tax;

    public void setTax(Double tax) {
        this.tax = tax;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();

        try {
            out.write(DecimalFormat.getInstance().format(tax));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
