package com.example.zjbapplication.imageloader.imageload;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtils {
    public CloseUtils(){

    }
    public static void close(Closeable closeable){
        if (null != closeable){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
