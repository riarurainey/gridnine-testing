package com.gridnine.testing.log;

import com.gridnine.testing.flight.Flight;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.*;

public class FilterLog {
    private static final Logger LOGGER = Logger.getLogger(FilterLog.class.getName());

    static {
        try {
            FileHandler handler = new FileHandler("logfile.txt");
            handler.setFormatter(new MyFormatter());
            LOGGER.setUseParentHandlers(false);
            LOGGER.addHandler(handler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Не удалось создать файл лога из-за ошибки ввода-вывода: ", e.getStackTrace());
        }
    }

    public static void logResults(String description, List<Flight> flightList) {

        try {
            LOGGER.info(String.format("Результат фильтрации по критерию: %s", description));
            flightList.forEach(flight -> LOGGER.info(flight.toString()));
            LOGGER.info("Конец результата фильтрации");

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Ошибка логирования: ", ex);
        }
    }

    private static class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return String.format("%s: %s: %s\n", record.getLevel(), LocalDateTime.now(), record.getMessage());
        }
    }
}
