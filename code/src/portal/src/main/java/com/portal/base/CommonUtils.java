package com.portal.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class CommonUtils {
	private static Logger LOGGER_ = Logger.getLogger(CommonUtils.class);

	public static String createRowId() {
		String timeMillis = String.valueOf(System.currentTimeMillis());
		return "nt" + timeMillis + UUID.randomUUID().toString().replace("-", "");
	}

	public static boolean stringIsNull(String s) {
		if (s == null || "".equals(s) || "null".endsWith(s)) {
			return true;
		}
		return false;
	}

	/**
	 * 通过http,向浏览器输出图片流
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 */
	public static void httpWriteImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String imageUrl) {
		httpServletResponse.setContentType("image/jpeg");
		File file = new File(imageUrl);
		if (!file.exists()) {
			LOGGER_.error("httpWriteImage error 图片不存在:" + imageUrl);
			return;
		}

		InputStream in = null;
		OutputStream os = null;
		try {
			in = new FileInputStream(file);
			os = httpServletResponse.getOutputStream();
			byte[] b = new byte[1024];
			while (in.read(b) != -1) {
				os.write(b);
			}
		} catch (FileNotFoundException e) {
			LOGGER_.error("图片读取失败:", e);
		} catch (IOException e) {
			LOGGER_.error("图片读取失败:", e);
		} finally {
			try {
				in.close();
				os.flush();
				os.close();
			} catch (IOException e) {
				LOGGER_.error("图片读取失败,关闭IO操作失败:", e);
			}
		}

	}

	/**
	 * 复制文件但不删除源文件
	 * 
	 * @param source
	 *            源文件路径
	 * @param target
	 *            目标文件路径
	 * @throws IOException
	 */
	public static void copyFileNoDel(String source, String target) throws IOException {
		File sourceFile = new File(source);
		if (!sourceFile.exists()) {
			throw new IOException("源文件路径不存在：" + source);
		}
		FileUtils.copyFile(sourceFile, new File(target));

	}

	/**
	 * 上传文件到目标文件夹
	 * 
	 * @param multipartFile
	 *            文件对象
	 * @param targetFolder
	 *            目标文件夹
	 * @param prefix
	 *            文件前缀,不带文件格式
	 * @return 新文件名
	 * @throws IOException
	 */
	public static String uploadFile(MultipartFile multipartFile, String targetFolder, String prefix)
			throws IOException {
		// 获取源文件名
		String filename = multipartFile.getOriginalFilename();
		String suffix = filename.substring(filename.lastIndexOf("."));
		String newFileName = prefix + suffix;
		// 创建目标文件夹
		File targerFolder = new File(targetFolder);
		if (!targerFolder.exists()) {
			targerFolder.mkdirs();
		}
		// 创建目标文件对象，并开始从源文件拷贝到目标文件
		File targetFile = new File(targetFolder, newFileName);
		multipartFile.transferTo(targetFile);
		return newFileName;
	}

	/**
	 * 将URL字符串分析成参数集合
	 * 
	 * @param url
	 * @return
	 */
	public static HashMap<String, String> AnalyzeURLParams(String url) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		String[] uParams;
		if (url.contains("?")) {
			String[] splitStr = url.split("\\?");
			uParams = splitStr[1].split("\\&");
		} else {
			uParams = url.split("\\&");
		}
		for (String param : uParams) {
			String[] pArr = param.split("=");
			paramMap.put(pArr[0], pArr[1]);
		}
		return paramMap;
	}
}
