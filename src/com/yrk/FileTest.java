package com.yrk;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("D:\\Eclipse SimRel\\WorkSpace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\manual-spring\\WEB-INF\\classes\\com\\yrk\\spring\\demo");
		File[] files = file.listFiles();
	}

}
