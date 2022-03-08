package com.kukyang.appraisal_web.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SelectOptionUtils {

    public static List<Long> generateYearOptions() {
        long year = LocalDateTime.now().getYear();
        List<Long> years = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            years.add(year - i);
        }

        return years;
    }
}
