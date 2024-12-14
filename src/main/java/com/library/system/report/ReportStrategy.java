package com.library.system.report;

import com.library.system.book.Book;
import java.util.List;

// Интерфейс для стратегии формирования отчетов
public interface ReportStrategy {
    void generateReport(List<Book> books);
}

// Реализация отчета по популярности
class PopularityReport implements ReportStrategy {
    @Override
    public void generateReport(List<Book> books) {
        // TODO: Логика для генерации отчета по популярности
        System.out.println("Generating Popularity Report...");
    }
}

// Реализация отчета по дате
class DateReport implements ReportStrategy {
    @Override
    public void generateReport(List<Book> books) {
        // TODO: Логика для генерации отчета по дате
        System.out.println("Generating Date-based Report...");
    }
}

// Класс для использования стратегии
class Report {
    private ReportStrategy reportStrategy;

    public void setReportStrategy(ReportStrategy reportStrategy) {
        this.reportStrategy = reportStrategy;
    }

    public void generateReport(List<Book> books) {
        if (reportStrategy != null) {
            reportStrategy.generateReport(books);
        }
    }
}
