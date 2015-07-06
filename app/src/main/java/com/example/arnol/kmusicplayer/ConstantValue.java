package com.example.arnol.kmusicplayer;

public interface ConstantValue {
	int SUCCESS = 0;
	int ERROR = 100;

	/**
	 * 服务器地址
	 */
	String URI = "http://10.0.2.2:8080/KMPlayerService/res";

	String SLICE_URI = "/json/slice.txt";
	String VIDEO_URI = "/json/video.txt";
	String ENCODING = "UTF-8";
	String IMAGE_PATH = "/img2";
}
