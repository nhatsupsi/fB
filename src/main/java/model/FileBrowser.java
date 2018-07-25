package model;

import Component.FileType;
import Component.ImageType;
import Component.VideoType;

import java.util.ArrayList;

public class FileBrowser {
    private String path;
    private ArrayList<FileType> fileTypes=new ArrayList<>();
    protected ArrayList<String> extendsList=new ArrayList<>();

    public FileBrowser(){
        this.fileTypes.add(new VideoType());
        this.fileTypes.add(new ImageType());
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
