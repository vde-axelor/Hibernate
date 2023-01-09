package com.project1.otmunidirectional;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PHONEUSER")
public class Phoneuser {
	@Id
    private int userid;
    private String useremail;
    private String username;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="USERID")
    private List<Phone> phoneTables;

    public int getUserid() {
            return userid;
    }

    public void setUserid(int userid) {
            this.userid = userid;
    }

    public String getUseremail() {
            return useremail;
    }

    public void setUseremail(String useremail) {
            this.useremail = useremail;
    }

    public String getUsername() {
            return username;
    }

    public void setUsername(String username) {
            this.username = username;
    }

    public List<Phone> getPhoneTables() {
            return phoneTables;
    }

    public void setPhoneTables(List<Phone> phoneTables) {
            this.phoneTables = phoneTables;
    }
}
