package controls;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEM 
{
    
        private JpaEM(){}
        
        private static class InstanceHolder 
        {
            private static final EntityManagerFactory INSTANCE = Persistence.createEntityManagerFactory("RestService");
        }
        
        public static EntityManagerFactory getInstance() 
        {
            return InstanceHolder.INSTANCE;
        }
}
