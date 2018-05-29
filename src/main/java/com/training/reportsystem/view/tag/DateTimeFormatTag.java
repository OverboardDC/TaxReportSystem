package com.training.reportsystem.view.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormatTag extends TagSupport {

    private LocalDateTime dateTime;

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    private Locale locale;

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public int doStartTag() throws JspException {
        DateTimeFormatter format = new DateTimeFormatterBuilder().
                append(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)).
                toFormatter(locale);
        JspWriter out = pageContext.getOut();
        try {
            out.write(dateTime.format(format));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
