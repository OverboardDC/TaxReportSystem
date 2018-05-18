package com.training.reportsystem.view.tag;

import com.training.reportsystem.util.i18n.LocalisationUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatTag extends TagSupport {

    private LocalDate date;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int doStartTag() throws JspException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(LocalisationUtil.getCurrentLanguage().getDatePattern());
        JspWriter out = pageContext.getOut();
        try {
            out.write(date.format(format));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
