package com.example.std_mang_sys.controllers;

import com.example.std_mang_sys.model.Marks;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;

public class MarksDetails {
    public List<Object>getDetails(List<Marks>coursesData){
        List<Object> marksDetails = new ArrayList<>();

        if(!coursesData.isEmpty()) {
            List<Integer> marks = new ArrayList<>();
            for (Marks mark : coursesData) {
                marks.add(mark.getMark());
            }

            OptionalDouble average =
                    marks
                            .stream()
                            .mapToDouble(a -> a)
                            .average();
            System.out.printf("marks Average: %s \n", average.getAsDouble());
            OptionalInt max = marks
                    .stream()
                    .mapToInt(a -> a)
                    .max();
            System.out.printf("marks max: %s \n", max.getAsInt());
            OptionalInt min = marks
                    .stream()
                    .mapToInt(a -> a)
                    .min();
            System.out.printf("marks min: %s \n", min.getAsInt());
            DoubleStream sortedNumbers = marks.stream()
                    .mapToDouble(v -> v)
                    .sorted();
            OptionalDouble median = (
                    marks.size() % 2 == 0 ?
                            sortedNumbers.skip((marks.size() / 2) - 1)
                                    .limit(2)
                                    .average() :
                            sortedNumbers.skip(marks.size() / 2)
                                    .findFirst()
            );
            System.out.printf("marks median: %s \n", median.getAsDouble());

            marksDetails.add("marks median: " + median.getAsDouble());
            marksDetails.add("marks average: " + average.getAsDouble());
            marksDetails.add("marks min value: " + (double) min.getAsInt());
            marksDetails.add("marks max value: " + (double) max.getAsInt());
        }
        else{
            marksDetails.add("sorry course does not exist");
        }
        return marksDetails;
    }
}
