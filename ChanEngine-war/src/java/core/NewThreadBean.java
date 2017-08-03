/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import com.google.common.base.Strings;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author admin
 */
@ManagedBean
@RequestScoped
public class NewThreadBean {
    
    @EJB
    private PostFacade posts;
    
    private String input = null;
    private Part fileUpload = null;
    private String fileName = null;

    public Part getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(Part fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
    
    public void post() {
        if ( !Strings.isNullOrEmpty( input ) ) {
            Post post = new Post( 0, input, Calendar.getInstance().getTime(), true, 1 );
            fileSave();
            post.setImagePath( fileName );
            posts.create( post );
        }
    }
    
    public void fileSave() {
        if ( fileUpload != null ) {
            try ( InputStream in = fileUpload.getInputStream() ) {
                String ext = fileUpload.getSubmittedFileName().substring( fileUpload.getSubmittedFileName().lastIndexOf( "." ) );
                fileName = Long.toString( Calendar.getInstance().getTimeInMillis() ) + ext;
                Files.copy( in, new File( "web/" + Post.BASE_UPLOAD_PATH + fileName ).toPath() );
            }
            catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }
    
}
