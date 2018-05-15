package com.example.test.servlets;

import com.example.test.config.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//@WebServlet("/saveAudio")
//@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Config conf = new Config();
        String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
        Part filePart = request.getPart("musicFile"); // Retrieves <input type="file" name="musicFile">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        // ... (do your job here)
        System.out.println(fileName);

        File file = new File(conf.getAudioPath(),fileName);

        try (InputStream input = fileContent) {
            System.out.println(file.toPath());
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }

}
