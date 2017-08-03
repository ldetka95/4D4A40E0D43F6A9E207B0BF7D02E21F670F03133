/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
    , @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id")
    , @NamedQuery(name = "Post.findByText", query = "SELECT p FROM Post p WHERE p.text = :text")
    , @NamedQuery(name = "Post.findByCreateTime", query = "SELECT p FROM Post p WHERE p.createTime = :createTime")
    , @NamedQuery(name = "Post.findByIsThread", query = "SELECT p FROM Post p WHERE p.isThread = :isThread")
    , @NamedQuery(name = "Post.findByCreatorId", query = "SELECT p FROM Post p WHERE p.creatorId = :creatorId")
    , @NamedQuery(name = "Post.findAllOrderByTime", query = "SELECT p FROM Post p ORDER BY p.createTime DESC")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4096)
    @Column(name = "text")
    private String text;
    @Lob
    @Size(max = 65535)
    @Column(name = "imagePath")
    private String imagePath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isThread")
    private boolean isThread;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creatorId")
    private int creatorId;
    
    public final static String BASE_UPLOAD_PATH = "threadImage/";//G:/EETrashDump/Chan/threadImage/";

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String text, Date createTime, boolean isThread, int creatorId) {
        this.id = id;
        this.text = text;
        this.createTime = createTime;
        this.isThread = isThread;
        this.creatorId = creatorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }
    
    public String imageAbsolutePath() {
        return BASE_UPLOAD_PATH + imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean getIsThread() {
        return isThread;
    }

    public void setIsThread(boolean isThread) {
        this.isThread = isThread;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }
    
    public boolean isImagePathNotNull() {
        return this.imagePath != null;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "core.Post[ id=" + id + " ]";
    }
    
}
