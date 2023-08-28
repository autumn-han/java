package com.coding_dojo.bookClub.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.coding_dojo.bookClub.models.Book;
import com.coding_dojo.bookClub.models.User;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
	List<Book> findByUser(User user);
}
