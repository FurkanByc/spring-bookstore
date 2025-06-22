package com.bookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bookStore.service.BackgroundBookUpdater;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BookStoreApplication.class, args);

        BackgroundBookUpdater updater = context.getBean(BackgroundBookUpdater.class);
        updater.start();  // Thread’i başlat
    }

}
