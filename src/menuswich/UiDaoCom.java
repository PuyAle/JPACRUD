
package menuswich;
import dao.ProductDAOImpl;
import run.JPACRUD;
import ui.UI;
public class UiDaoCom {
    
    
  //  
    
    public static void DBUIConnection(int i){
       ProductDAOImpl db = new ProductDAOImpl();
       UI ui = new UI();
        boolean loop = true;
       
        while (loop){
            switch (i){
                case 1: 
                    db.create(ui.enterName(), ui.enterPrice());
                    
                    break;
                case 2:
                    ui.printList(db.getAll());
                    break;
                case 3:
                    ui.printList(db.getByName(ui.enterName()));
                    break;
                case 4: 
                    ui.printList(db.getByPriceRange(ui.enterPrice(), ui.enterPrice()));
                    break;
                case 5:
                   
                    db.updateName(ui.enterId(), ui.enterName());
                    
                    break;
                case 6:
                    db.updatePrice(ui.enterId(), ui.enterPrice());
                    
                    break;
                case 7: 
                    db.remove(ui.enterId());
                    
                    break;
                case 0:
                    //lägg in en metod som skapats i daoimpl klassen som 
                    //avslutar emf i en try catch. dvs. att den ska avsluta den 
                    //enbart om det finns en dvs emf !=null.  
                    loop = false;
                    JPACRUD.loop=false;
                    
                    break;
                default:
                    DBUIConnection(ui.menu());
                    break;
            }
            loop=false;
        }
    }
}
