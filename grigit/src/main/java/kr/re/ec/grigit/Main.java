package kr.re.ec.grigit;

import kr.re.ec.grigit.ui.controller.MainController;

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
       MainController.getInstance().init();
    }
}
