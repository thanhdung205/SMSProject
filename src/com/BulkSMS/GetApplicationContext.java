package com.BulkSMS;

import android.app.Application;
import android.content.Context;

public class GetApplicationContext extends Application {
	private  Application instance = null;

    GetApplicationContext()
    {
        instance = this;
    }

    public  Context getInstance()
    {
        if (null == instance)
        {
            instance = new Application();
        }

        return instance;
    }

}
