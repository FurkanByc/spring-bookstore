package com.bookStore.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
	}
	
	public List<Book> getAllBook(){
		return bRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bRepo.findById(id).orElse(null);
	}
	
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
	
	// Fiyata göre küçükten büyüğe sıralama
	public List<Book> getBooksSortedByPrice() {
		return bRepo.findAll()
				.stream()
				.sorted(Comparator.comparingDouble(Book::getPrice))
				.collect(Collectors.toList());
	}
	
	// Kitap adına göre arama
	public List<Book> searchBooksByName(String keyword) {
		return bRepo.findAll()
				.stream()
				.filter(book -> book.getName().toLowerCase().contains(keyword.toLowerCase()))
				.collect(Collectors.toList());
	}
}