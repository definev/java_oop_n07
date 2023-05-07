package vn.viettuts.qlsv.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xeList")
@XmlAccessorType(XmlAccessType.FIELD)
public class XeXML {
    
    private List<Xe> xe;

    public List<Xe> getStudent() {
        return xe;
    }

    public void setStudent(List<Xe> xe) {
        this.xe = xe;
    }
}
