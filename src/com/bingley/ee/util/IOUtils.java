package com.bingley.ee.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	/**
	 * 私有化
	 */
	private IOUtils() {
	}

	/**
	 * 将inputstream转换成outputstream
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void In2Out(InputStream in,OutputStream out) throws IOException{
		byte [] bs = new byte[1024];
		int i = 0;
		while((i=in.read(bs))!=-1){
			out.write(bs,0,i);
		}
	}

	/**
	 * 关闭流
	 * @param in
	 * @param out
	 */
	public static void close(InputStream in,OutputStream out){
		if(in!=null){
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				in = null;
			}
		}
		if(out!=null){
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				out = null;
			}
		}
	}
}
