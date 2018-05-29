package com.training.reportsystem.view.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormatTag extends TagSupport {

    private LocalDate date;

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    private Locale locale;

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public int doStartTag() throws JspException {
        DateTimeFormatter format = new DateTimeFormatterBuilder().
                append(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)).
                toFormatter(locale);
        JspWriter out = pageContext.getOut();
        try {
            out.write(date.format(format));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
