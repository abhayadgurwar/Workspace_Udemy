package com.in28minutes.learnspringframework.examples.c1;

import com.in28minutes.learnspringframework.examples.c1.DataService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component
@Repository
public class MySQLDbDataService implements DataService {

        @Override
        public int[] retrieveData() {
            return new int[] {1,2,3,4,5};
        }

}
