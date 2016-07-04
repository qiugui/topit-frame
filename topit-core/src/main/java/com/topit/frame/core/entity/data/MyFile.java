 package com.topit.frame.core.entity.data;

import org.springframework.stereotype.Component;
 /** 
* @ClassName: MyFile 
* @Description: 文件上传下载界面中，下拉框对应的选项 
* @author qiugui 
* @date 2015年2月11日 上午11:34:08 
*  
*/ 
@Component("myFile")
 public class MyFile {
	 private String id;
	 private String fileName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}

 