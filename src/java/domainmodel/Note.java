/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 617702
 */
@Entity
@Table(name = "note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n")
    , @NamedQuery(name = "Note.findByNoteID", query = "SELECT n FROM Note n WHERE n.noteID = :noteID")
    , @NamedQuery(name = "Note.findByDateCreated", query = "SELECT n FROM Note n WHERE n.dateCreated = :dateCreated")
    , @NamedQuery(name = "Note.findByTitle", query = "SELECT n FROM Note n WHERE n.title = :title")
    , @NamedQuery(name = "Note.findByContents", query = "SELECT n FROM Note n WHERE n.contents = :contents")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "noteId")
    private Integer noteId;
    @Basic(optional = false)
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(name = "contents")
    private String contents;
    
    public Note()
    {
        
    }
    public Note(int noteId, String contents) 
    {
        this.dateCreated = new Date();
        this.noteId = noteId;
        this.contents = contents;
    }

    public Note(int noteId) 
    {
        this.dateCreated = new Date();
        this.noteId = noteId;
    }

    public Note(String contents) 
    {
        this.dateCreated = new Date();
        this.contents = contents;
    }

    public Integer getNoteId() 
    {
        return noteId;
    }

    public void setNoteId(Integer noteId) 
    {
        this.noteId = noteId;
    }

    public Date getDate() 
    {
        return dateCreated;
    }

    public void setDate(Date date) 
    {
        this.dateCreated = date;
    }
    
    public int getId() 
    {
        return noteId;
    }

    public void setId(int id) 
    {
        this.noteId = id;
    }

    @Override
    public int hashCode() 
    {
        int hash = 0;
        hash += (noteId != null ? noteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) 
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) 
        {
            return false;
        }
        Note other = (Note) object;
        if ((this.noteId == null && other.noteId != null) || (this.noteId != null && !this.noteId.equals(other.noteId))) 
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return "domainmodel.Note[ noteId=" + noteId + " ]";
    }

    public String getContents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
