package ru.office.config;

import org.hsqldb.util.DatabaseManagerSwing;

public class DatabaseManagerSwingThread extends Thread{

    public final String DB_NAME = "web-office-db";

    public void run(){
        DatabaseManagerSwing.main(new String[] {
                "--url", "jdbc:hsqldb:mem:"+DB_NAME, "--noexit", "--user", "sa", "--password", "" });
      /*  org.hsqldb.util.DatabaseManager.main(new String[] {
                "--url",  "jdbc:hsqldb:mem:testdb", "--noexit"
        });*/
    }
}


