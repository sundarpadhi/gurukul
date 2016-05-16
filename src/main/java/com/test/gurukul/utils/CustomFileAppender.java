package com.test.gurukul.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;

//CustomFIle appender for log4j---

public class CustomFileAppender extends  FileAppender{

    @Override
    public void setFile(String fileName)
    {
        if (fileName.indexOf("%timestamp") >= 0) {
            Date d = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
            fileName = fileName.replaceAll("%timestamp", format.format(d));
        }
        super.setFile(fileName);
   }
}