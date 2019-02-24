package run;

import ui.UI;
import menuswich.UiDaoCom;
//
public class JPACRUD {

    public static boolean loop = true;

    public static void main(String[] args) {
        
        while (loop){
        UiDaoCom.DBUIConnection(UI.menu());
        }
    }

}
