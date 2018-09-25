package org.bitbucket.lcleite.desafioandroid.bdd;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;


public class MockResponse {

    public static <T> T fromJson(String filename, Class<T> tClass) {
        URL fileUrl = MockResponse.class.getClassLoader().getResource(filename);
        File file = new File(fileUrl.getFile());
        Reader reader = null;

        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(reader, tClass);
    }

}
