package com.example.demo.components;

import com.example.demo.models.File;
import com.example.demo.models.Folder;
import com.example.demo.models.Person;
import com.example.demo.repository.FileRepository;
import com.example.demo.repository.FolderRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("!test") //Run every time EXCEPT Tests
@Component

public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    PersonRepository personRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {
        Person person1 = new Person("Kieran", "Rooney");
        personRepository.save(person1);

        Folder folder1 = new Folder("CodeClan", person1);
        folderRepository.save(folder1);

        File file1 = new File("homework", "txt", 1028, folder1);
        fileRepository.save(file1);
    }
}
