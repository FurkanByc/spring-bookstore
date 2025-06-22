package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;

@Service
public class BackgroundBookUpdater implements Runnable {

    private volatile boolean running = true;

    @Autowired
    private BookService bookService;

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            List<Book> books = bookService.getAllBook();
            System.out.println("Books count: " + books.size());

            try {
                Thread.sleep(10000); // 10 saniye bekle
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
