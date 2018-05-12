package com.training.reportsystem.util.tag;

import com.training.reportsystem.util.i18n.LocalisationUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatTag extends TagSupport {

    private LocalDateTime dateTime;

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public int doStartTag() throws JspException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(LocalisationUtil.getCurrentLanguage().getDateTimePattern());
        JspWriter out = pageContext.getOut();
        try {
            out.write(dateTime.format(format));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return SKIP_PAGE;
    }
}
