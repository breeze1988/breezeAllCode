package com.example.administrator.breezeallcode.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2015/11/13.
 * IO 工具类
 */
public class StreamUtils {

    /**
     * 重文件中获取数据
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static byte[] readFile(File file) throws FileNotFoundException {
        return readInputStream(new FileInputStream(file));
    }

    /**
     * 从输入流获取数据
     *
     * @param in
     * @return
     */
    public static byte[] readInputStream(InputStream in) {
        byte[] buffer = new byte[1024 * 4];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len = -1;
        try {
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeIO(out);
            closeIO(in);
        }
        return null;
    }

    /**
     * 关闭IO流
     *
     * @param io
     */
    public static void closeIO(Closeable io) {
        if (io != null) {
            try {
                io.close();
            } catch (IOException e) {
            }
            io = null;
        }
    }


}
