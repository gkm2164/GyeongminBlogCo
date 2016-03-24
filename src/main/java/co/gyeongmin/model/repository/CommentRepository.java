package co.gyeongmin.model.repository;

import co.gyeongmin.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gyeongmin on 3/24/16.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> { }
