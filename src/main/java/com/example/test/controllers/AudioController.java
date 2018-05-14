package com.example.test.controllers;

import com.example.test.Config;
import com.example.test.entities.Audio;
import com.example.test.services.AudioService;
import com.example.test.servlets.FileUploadServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import java.util.Optional;

@Controller
@MultipartConfig(maxFileSize = 1024*1024*1024, maxRequestSize = 1024*1024*1024)
public class AudioController extends HttpServlet {

    @Autowired
    private AudioService audioService;

    @RequestMapping(value = "/saveAudio", method = RequestMethod.POST)
    public String saveAudio(Audio audio, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Config conf = new Config();
        //String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
        Part filePart = request.getPart("musicFile"); // Retrieves <input type="file" name="musicFile">
        if (filePart != null){
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            // ... (do your job here)
            System.out.println(fileName);
            File file = new File(conf.getAudioPath(),fileName);

            try (InputStream input = fileContent) {
                System.out.println(file.toPath());
                Files.copy(input, file.toPath());
            }catch (Exception e){
                response.sendRedirect("/sendError"); //Сделать html
            }
            audio.setMusic("audio/"+fileName);
            audioService.save(audio);
        }
        return "redirect:/";
    }

    @GetMapping("/deleteAudio")
    public String deleteAudio(Integer id){
        audioService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/findOneAudio")
    @ResponseBody
    public Optional<Audio> findOneAudio(Integer id){
        return audioService.findById(id);
    }

}
