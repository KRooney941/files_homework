package com.example.demo;

import com.example.demo.models.File;
import com.example.demo.models.Folder;
import com.example.demo.models.Person;
import com.example.demo.repository.FileRepository;
import com.example.demo.repository.FolderRepository;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	PersonRepository personRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createFolderAndPersonThenSave(){
		Person person1 = new Person("Kieran", "Rooney");
		personRepository.save(person1);

		Folder folder1 = new Folder("CodeClan", person1);
		folderRepository.save(folder1);
	}

	@Test
	public void createFolderAndFileThenSave(){
		Person person1 = new Person("Kieran", "Rooney");
		personRepository.save(person1);

		Folder folder1 = new Folder("CodeClan", person1);
		folderRepository.save(folder1);

		File file1 = new File("homework", "txt", 1028, folder1);
		fileRepository.save(file1);
	}

}
