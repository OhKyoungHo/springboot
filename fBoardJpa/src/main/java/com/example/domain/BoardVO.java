package com.example.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Data;

@Data
@Entity
@Table(name="board")
public class BoardVO {
	
	@Id
	@GeneratedValue
	private Integer seq;		//PK 역할 부여
	private String writer;
	private String title;
	private String content;
	@Column(insertable=false, updatable=false, columnDefinition = "date default sysdate")
	//입력할수 없고, 수정 불가하고 해당 데이터 타입은 date, 값은 오늘 날짜로 지정
	private Date regdate;
	@Column(columnDefinition = "number default 0")
	private Integer cnt;

    @PrePersist
    public void prePersist() {
        this.cnt = this.cnt == null ? 0 : this.cnt;
        //this.regdate = this.regdate ==null ? (뭘까) : this.regdate;
    }
    
  

}
