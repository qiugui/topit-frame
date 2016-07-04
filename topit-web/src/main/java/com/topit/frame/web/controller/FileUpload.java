package com.topit.frame.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;







import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;




import com.topit.frame.busniess.imp.ExcelToTableService;
import com.topit.frame.busniess.imp.FileTransmission;
import com.topit.frame.core.entity.data.MyFile;


/** 
* @ClassName: FileUpload 
* @Description: 文件上传下载控制器 
* @author qiugui 
* @date 2014年12月9日 下午12:19:10 
*  
*/ 
@Controller
@RequestMapping("/fileupload")
public class FileUpload {

	/** 
	* @Fields fileTransmission :文件传输工具类
	*/ 
	@Resource(name = "fileTransmission")
	FileTransmission fileTransmission;

	/** 
	* @Fields excelToTableService : excel转数据库表的服务类 
	*/ 
	@Resource(name = "excelToTableService")
	ExcelToTableService excelToTableService;

	/**   
	 * @Title: fileUpload   
	 * @Description: 上传文件   
	 * @param file
	 * @param request
	 * @param response
	 * @return        
	 */
	 
	@RequestMapping("/upload")
	@Transactional
	public String fileUpload(@RequestParam("theFile") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {

		String fileflag=request.getParameter("fileflag");

		String fileOriginName=file.getOriginalFilename();
		/*
		 * 判断上传文件是否是该模块页面对应的指定模版文件
		 */
		//获取上传文件的文件名
		if("".equals(fileOriginName)){
			return "/fileUploadFail/fail3";
		}
		String fileName=fileOriginName.substring(0, file.getOriginalFilename().indexOf("."));
		// 获取上传文件的后缀名
		String suffix = fileOriginName.substring(file.getOriginalFilename().lastIndexOf("."));
		
		if ("userinfo".equals(fileflag) && !"用户信息".equals(fileName)){
			return "/fileUploadFail/fail3";
		}
		
		if (!(".xlsx".equals(suffix) || ".xls".equals(suffix))){
			return "/fileUploadFail/fail1";
		}
		
		if (file.isEmpty()){
			return "/fileUploadFail/fail2";
		}

		// 指定上传文件在服务器中的文件目录
		String path = request.getSession().getServletContext().getRealPath("/")
				+ "\\uploadFile\\";

		return fileTransmission.uploadFile(file, path,fileflag);
		
	}

	/**   
	 * @Title: listAllFiles   
	 * @Description: 向前台下拉框列出目录中所有文件   
	 * @param request
	 * @param response        
	 */
	 
	@RequestMapping("/listAllFiles")
	@ResponseBody
	public void listAllFiles(HttpServletRequest request,
			HttpServletResponse response) {
		String filedirPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\download";
		File filedir = new File(filedirPath);
		List<MyFile> list = new ArrayList<MyFile>();
		if (filedir.isDirectory()) {
			File files[] = filedir.listFiles();
			for (int i = 0; i < files.length; i++) {
				MyFile myFile = new MyFile();
				myFile.setId(i + "");
				myFile.setFileName(files[i].getName());
				list.add(myFile);
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		String json = JSONArray.fromObject(list).toString();
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**   
	 * @Title: download   
	 * @Description: 下载文件   
	 * @param request
	 * @param response        
	 */
	 
	@RequestMapping("/download")
	@ResponseBody
	public void download(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		String fileName = "";
		String fileNamePath = "";
		try {
			// 下载文件于路径中的文件名
			fileNamePath = java.net.URLDecoder.decode(
					request.getParameter("fileName"), "UTF-8");
			// 下载文件显示的文件名
			fileName = new String(request.getParameter("fileName").getBytes(
					"gb2312"), "ISO8859-1");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);

		// fileName=fileName.replace(' ', '+');
		String path = request.getSession().getServletContext()
				.getRealPath("/download/" + fileNamePath);
		fileTransmission.downloadFile(response, path);

	}

}
