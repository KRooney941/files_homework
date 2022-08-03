package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="folders")
public class Folder {

    @Column(name = "title")
    private String title;


    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    //You can use JsonBackReference here as an alternative
    @JsonIgnoreProperties({"folders"})
    private Person person;



    @OneToMany(mappedBy = "folder", fetch = FetchType.LAZY)
    //You can use JsonBackReference here as an alternative
    @JsonIgnoreProperties({"folders"})
    private List<File> files;

    public Folder(String title, Person person) {
        this.title = title;
        this.person = person;
        this.files = new ArrayList<>();
    }

    public Folder(){

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void addFiles(File file){
        this.files.add(file);
    }
}
