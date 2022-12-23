package com.example.domain;

import lombok.Data;

//Board_file 테이블 VO
@Data
public class FileVO {

	private Long fileId;
	private String origFilename;
	private String filename;
	private String filepath;
	
	
}
