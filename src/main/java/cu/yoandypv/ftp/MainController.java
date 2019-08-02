package cu.yoandypv.ftp;

import cu.yoandypv.ftp.exceptions.FTPErrors;
import cu.yoandypv.ftp.ftpclient.FTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * Created by Yoandy Pérez Villazón 14/09/17.
 */
@RestController
public class MainController {

    @Autowired
    private FTPService ftpService;

    @RequestMapping( value = "/upload", method = RequestMethod.GET)
    public void uploadExample(){
        try {

              ftpService.connectToFTP("192.168.101.144","app","app");
              //ftpService.makeDirectory("test120");

              //serverPath 是相对于ftp用户家目录的相对目录
              ftpService.uploadFileToFTPByPath(new File("d:\\demo.lic"),"test37/test01/test02","demo11.lic");
              //ftpService.uploadFileToFTP(new File("d:\\demo.lic"),"/test01/","demo11.lic");
              //ftpService.downloadFileFromFTP("123.txt","d:\\123.txt");

        } catch (FTPErrors ftpErrors) {
            System.out.println(ftpErrors.getMessage());
        }
    }


}
