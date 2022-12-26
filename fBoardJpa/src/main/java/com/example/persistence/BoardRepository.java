package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.BoardVO;

//**********************
//CrudRepository<T,Id> : T는 Entity의 타입클래스이고 ID는 P.K 값의 Type 이다. 
public interface BoardRepository extends CrudRepository<BoardVO, Integer>
{
	
	

}

/*CrudRepository<T,ID>
 * 		T: 엔티티 클래스 타입
 * 		ID : 식별자 타입
 * 	- long count()
 * 	- void deleteById(ID)
 * 	- void deleteAll()
 * 	- boolean existsById(ID)
 * 	- Iterable<T> findAll()
 * 	- Optional<T> findById(ID)
 * 	- <S extends T>S save(S)
 * 
 * */
 