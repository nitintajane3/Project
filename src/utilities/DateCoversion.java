package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class  DateCoversion {

    public String dateconvert()
    {
        DateFormat dateformat = new SimpleDateFormat("MMMM d, yyyy");
        Date date = new Date();
        String date1= dateformat.format(date);
        return date1;
    }

}
