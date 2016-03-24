package co.gyeongmin.model.repository;

import co.gyeongmin.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gyeongmin on 3/24/16.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> { }
