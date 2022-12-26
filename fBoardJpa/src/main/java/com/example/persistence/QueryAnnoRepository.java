package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.domain.BoardVO;

public interface QueryAnnoRepository extends CrudRepository<BoardVO, Integer> {

	//[1] JPQL (복잡한 쿼리)
	   //@Query("SELECT b FROM BoardVO b WHERE b.title LIKE %?1% ORDER BY b.seq DESC")
	   //List<BoardVO> queryAnnotation(String word);
	
	//[2] SQL(복잡한 쿼리)
	  @Query(value="SELECT * FROM board WHERE title LIKE '%'||?1||'%' ORDER BY seq DESC", nativeQuery = true)
	   List<BoardVO> queryAnnotation2(String word);
	   
	//[3] SQL join : board + board_file :: record returns HashMap instead of BoardVO
	   @Query(value="SELECT b.seq as seq, b.title title, b.writer , b.regdate, b.cnt, bf.filepath FROM BOARD b "
	         + "full outer join BOARD_FILE bf ON b.title = bf.filename "
	         + "where b.title like '%'||?1||'%' order by b.seq desc", nativeQuery=true)
	   List<Object[]> queryAnnotation3(String word);


	   
	
	
}
