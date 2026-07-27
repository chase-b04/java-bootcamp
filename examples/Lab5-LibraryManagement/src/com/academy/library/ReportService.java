package com.academy.library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class ReportService {

    private final LibraryService libraryService;

    public ReportService(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void displaySummaryReport() {
        // TODO: compute totalBooks, borrowedBooks, availableBooks, totalMembers
        int totalBooks = libraryService.getBooks().size();
        int borrowedBooks = libraryService.getBorrowRecords().size();
        int availableBooks = totalBooks - borrowedBooks;
        int totalMembers = libraryService.getMembers().size();
        System.out.printf("Reports%nBooks : %d%nBorrowed : %d%nAvailable : %d%nMembers : %d%n", totalBooks, borrowedBooks, availableBooks, totalMembers);
        // TODO: findMostPopularCategory(); print Reports block matching solution format
        String popularCategory = findMostPopularCategory();
        System.out.println("Most Popular Category : " + popularCategory);
//        throw new UnsupportedOperationException("TODO");
    }

    public Path exportReportToFile(String fileName) throws IOException {
        // TODO: build same summary + category breakdown; Files.writeString; return Path
        int totalBooks = libraryService.getBooks().size();
        int borrowedBooks = libraryService.getBorrowRecords().size();
        int availableBooks = totalBooks - borrowedBooks;
        int totalMembers = libraryService.getMembers().size();
        String popularCategory = findMostPopularCategory();

        StringBuilder report = new StringBuilder(fileName);
        report.append("Library Report\n");
        report.append("Books : ").append(totalBooks).append("\n");
        report.append("Borrowed : ").append(borrowedBooks).append("\n");
        report.append("Available : ").append(availableBooks).append("\n");
        report.append("Members : ").append(totalBooks).append("\n");
        report.append("Most Popular Category : ").append(popularCategory).append("\n");

        Path path = Path.of(fileName);
        Files.writeString(path, report.toString());
        System.out.println("Successfully written to " + fileName);
        return path;
//        throw new UnsupportedOperationException("TODO");

    }

    private String findMostPopularCategory() {
        // TODO: max entry by value from getCategoryBookCount(); orElse "N/A"
        Map.Entry<String, Integer> mostPopular = null;
        for (Map.Entry<String, Integer> category : libraryService.getCategoryBookCount().entrySet()) {
            if (mostPopular == null || category.getValue().compareTo(mostPopular.getValue()) > 0) {
                mostPopular = category;
            }
        }
        if (mostPopular == null) {
            return "N/A";
        }
        else {
            return mostPopular.getKey();
        }
//        throw new UnsupportedOperationException("TODO");
    }
}