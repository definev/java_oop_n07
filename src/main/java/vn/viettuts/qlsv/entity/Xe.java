package vn.viettuts.qlsv.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xe")
@XmlAccessorType(XmlAccessType.FIELD)
public class Xe implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String thoiGian;
    private String khuVuc;

    public Xe() {
    }

    public Xe(String id, String name, String thoiGian, String khuVuc) {
        super();
        this.id = id;
        this.name = name;
        this.thoiGian = thoiGian;
        this.khuVuc = khuVuc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBienSo() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }
}
