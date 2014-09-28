package kr.re.ec.grigit;

import java.io.File;
import java.nio.file.FileSystemNotFoundException;

import org.apache.http.client.UserTokenHandler;

import kr.re.ec.grigit.ui.controller.MainController;
import kr.re.ec.grigit.ui.controller.UserSettingController;

/**
 * Hello world!
 *
 * @author Kang Juho
 * @version $Revision: 1.0 $
 */
public class Main
{
    /**
     * Method main.
     * @param args String[]
     */
    public static void main( String[] args )
    {
    	UserSettingController usc =  new UserSettingController();
    	if(usc.isOk()){
    		MainController.getInstance().init();
    	} else {
    		System.exit(1);
    	}
    	
    }
}
