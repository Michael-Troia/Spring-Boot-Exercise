package com.codeup.blog.repos;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
//@Query("from Post p where p.id like ?1")
//    Post getPostById(long id);

}

