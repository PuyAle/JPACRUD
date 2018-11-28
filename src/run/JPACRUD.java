package run;

import ui.UI;
import uidaocom.UiDaiCom;

public class JPACRUD {

    public static boolean loop = true;

    public static void main(String[] args) {
        
        while (loop){
        UiDaiCom.DBUIConnection(UI.menu());
        }
    }

}
