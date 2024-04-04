package com.bitc.java404;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class JavaOutputStream {
    public void write1(String filename) throws IOException {
        // OutputStream은 모든 바이트 타입 스트림의 최상위 클래스이며
        // 추상 클래스이므로 객체 생성 불가능
        // 부모 클래스인 OutputStream 클래스 타입의 변수에
        // 자식 클래스인 FileOutputStream 클래스 타입의 객체를 저장하여 사용함
        OutputStream os = new FileOutputStream(filename);

        // byte[] 배열 data에 입력하고자 하는 문자열을 byte 타입으로 변환하여 저장
        byte[] data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();

        // byte[] 배열에 저장된 데이터를 파일에 쓰기
        for (int i = 0; i < data.length; i++) {
            // write()를 사용하여 실행 시마다 1byte씩 파일에 쓰기
            os.write(i);
        }
        // 버퍼에 저장된 내용을 즉시 파일에 쓰기
        os.flush();

        // 파일 닫기
        os.close();
    }



    // write(byte[] buff)
    public void write2(String filename) throws IOException {
        // 파일열기
        OutputStream os = new FileOutputStream(filename);
        // byte[] 배열에 저장된 데이터를 파일에 쓰기
        byte[] data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();
        // write(byte[] buff)를 사용하여 byte[] 배열에 저장된 내용을 한번에 쓰기
        os.write(data);
        // 버퍼에 저장된 내용을 파일에 쓰기
        os.flush();
        // 파일 닫기
        os.close();
    }



    // write(byte[] buff, int off, int len)
    public  void write3(String filename) throws IOException {
        OutputStream os = new FileOutputStream(filename);
        byte[] data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();

        // write(byte[] buff, int off, int len)를 사용하여 byte[] 배열의 내용 중
        // 지정한 index에서부터 지정한 크기의 데이터를 파일에 씀
        os.write(data,5,5);
        os.flush();
        os.close();
    }
}
