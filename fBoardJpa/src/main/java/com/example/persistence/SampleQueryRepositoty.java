package com.example.persistence;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import com.example.domain.BoardVO;

public interface SampleQueryRepositoty extends CrudRepository<BoardVO, Integer>
{
	  // 제목검색
 List<BoardVO> findBoardVOByTitle(String title);
  
  List<BoardVO> findBoardVOByTitleContainingOrderByTitleDesc(String title);
  //전체검색을 페이징
  List<BoardVO> findAll(Pageable paging);


}

/* 조건검색										==> 쿼리메소드
 * where title=?1								findBoardVOByTitle()	
 * where lastname=?1							findEmployeesByLastname()
 * where lastname<>?1(같지않다)					findEmployeesByLastnameNot()
 * where lastname=?1 and firstname=?2			findEmployeesByLastnameAndFirstname()
 * where startDate between ?1 and ?2			findEmployeesByStartDateBetween()
 * where age < ?1								findEmployeesByAgeLessThan()
 * where age <= ?1								findEmployeesByAgeLessThanEquel()
 * where age is null							findEmployeesByAgeIsNull()
 * where age is not null						findEmployeesByAgeIsNotNull()
 * where firstname like '%'||?||'%'				findEmployeesByFirstNameContaining()
 * where age =?1 order by lastname desc			findEmployeesByAgeOrderByLastnameDesc()
 * 
 * */
 