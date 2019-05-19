package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld.format(DateTimeFormatter.ofPattern("yyyy/MM-dd")));

        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);
        System.out.println(formattedDate);
    }



}
