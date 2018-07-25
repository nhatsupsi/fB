package state;

import java.util.ArrayList;

public class DataPacket {
    private String path=null;
    private ArrayList<String> extendsList=new ArrayList<>();
    private String otherExtends=null;

    protected String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    protected ArrayList<String> getExtendsList() {
        return extendsList;
    }

    public void addExtendsList(String extendsElement) {
        if(extendsElement!=null)
            this.extendsList.add(extendsElement);
    }

    protected String getOtherExtends() {
        return otherExtends;
    }

    public void setOtherExtends(String otherExtends) {
        this.otherExtends = otherExtends;
    }
}
